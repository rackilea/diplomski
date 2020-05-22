/** A label field with custom font and color attributes */
   private class CustomLabelField extends LabelField {

      private int fontColor = Color.BLACK;

      public CustomLabelField(String text, Font f, int color, long style) {
         super(text, style);
         setFont(f);
         fontColor = color;
      }      

      public void paint(Graphics g) {
         int oldColor = g.getColor();

         g.setColor(fontColor);
         super.paint(g);

         // reset graphics context
         g.setColor(oldColor);
      }
   }