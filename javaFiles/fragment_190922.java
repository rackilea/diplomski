public class DiscField extends Field {

   /** Used to map Manager's TouchEvents into our coordinate system */
   private int _offset = 0;
   private int _radius;
   private int _fillColor;
   private double _currentRotation = 0.0;
   private double _lastTouchAngle = 0.0;
   private boolean _rotating = false;
   private String[] _labels;
   /** Text inset from outer disc edge */
   private static final int INSET = 30;  

   private DiscField() {      
   }

   public DiscField(String[] labels, int radius, int fillColor) {
      super(Field.FOCUSABLE);
      _labels = labels;
      _radius = radius;
      _fillColor = fillColor;
   }    

   protected void layout(int width, int height) {
      setExtent(Math.min(width, getPreferredWidth()), Math.min(height, getPreferredHeight()));
   }

   private void drawFilledCircle(Graphics g, int x, int y, int r) {
      // http://stackoverflow.com/a/1186851/119114
      g.fillEllipse(x, y, x + r, y, x, y + r, 0, 360);
   }

   private void drawCircle(Graphics g, int x, int y, int r) {
      g.drawEllipse(x, y, x + r, y, x, y + r, 0, 360);
   }

   protected void paint(Graphics graphics) {
      int oldColor = graphics.getColor();
      graphics.setColor(_fillColor);
      drawFilledCircle(graphics, _radius, _radius, _radius);
      graphics.setColor(Color.WHITE);
      drawCircle(graphics, _radius, _radius, _radius);

      // plot the text around the circle, inset by some 'padding' value
      int textColor = (_fillColor == Color.WHITE) ? Color.BLACK : Color.WHITE; 
      graphics.setColor(textColor);
      // equally space the labels around the disc
      double interval = (2.0 * Math.PI / _labels.length);
      for (int i = 0; i < _labels.length; i++) {
         // account for font size when plotting text
         int fontOffsetX = getFont().getAdvance(_labels[i]) / 2;
         int fontOffsetY = getFont().getHeight() / 2;
         int x = _radius + (int) ((_radius - INSET) * Math.cos(i * interval - _currentRotation)) - fontOffsetX;
         int y = _radius - (int) ((_radius - INSET) * Math.sin(i * interval - _currentRotation)) - fontOffsetY;
         graphics.drawText(_labels[i], x, y);
      }

      graphics.setColor(oldColor);
   }

   protected void drawFocus(Graphics graphics, boolean on) {
      if (on) {
         int oldColor = graphics.getColor();
         int oldAlpha = graphics.getGlobalAlpha();
         // just draw a white shine to indicate focus
         graphics.setColor(Color.WHITE);
         graphics.setGlobalAlpha(80);
         drawFilledCircle(graphics, _radius, _radius, _radius);
         // reset graphics context
         graphics.setColor(oldColor);
         graphics.setGlobalAlpha(oldAlpha);
      }
   }  

   protected void onUnfocus() {
      super.onUnfocus();
      _rotating = false;
   }

   protected boolean touchEvent(TouchEvent event) {
      switch (event.getEvent()) {
      case TouchEvent.MOVE: {
         setFocus();         
         // Get the touch location, within this Field
         int x = event.getX(1) - _offset - _radius;
         int y = event.getY(1) - _offset - _radius;
         if (x * x + y * y <= _radius * _radius) {
            double angle = MathUtilities.atan2(y, x);
            if (_rotating) {
               // _lastTouchAngle only valid if _rotating
               _currentRotation += angle - _lastTouchAngle;
               // force a redraw (paint) with the new rotation angle
               invalidate();
            } else {
               _rotating = true;
            }         
            _lastTouchAngle = angle;

            return true;
         }
      }
      case TouchEvent.UNCLICK:
      case TouchEvent.UP: {
         _rotating = false;
         return true;      
      }  
      case TouchEvent.DOWN: {
         setFocus();                 
         int x = event.getX(1) - _offset - _radius;
         int y = event.getY(1) - _offset - _radius;
         if (x * x + y * y <= _radius * _radius) {
            _lastTouchAngle = MathUtilities.atan2(y, x);
            _rotating = true;
            return true;
         }
      }
      default:
         break;
      }           
      return super.touchEvent(event);
   }

   protected boolean trackwheelRoll(int arg0, int arg1, int arg2) {
      return super.trackwheelRoll(arg0, arg1, arg2);
      // TODO!
   }

   public int getPreferredHeight() {
      return getPreferredWidth();
   }

   public int getPreferredWidth() {
      return 2 * _radius;
   }

   public String[] getLabels() {
      return _labels;
   }

   public void setLabels(String[] labels) {
      this._labels = labels;
   }

   public int getRadius() {
      return _radius;
   }

   public void setRadius(int radius) {
      this._radius = radius;
   }

   public double getCurrentAngle() {
      return _currentRotation;
   }

   public void setCurrentAngle(double angle) {
      this._currentRotation = angle;
   }

   public int getOffset() {
      return _offset;
   }

   public void setOffset(int offset) {
      this._offset = offset;
   }
}