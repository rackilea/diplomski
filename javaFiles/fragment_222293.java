protected IFigure createFigure() {
    IFigure f = super.createFigure();
    f.addLayoutListener(new LayoutListener.Stub(IFigure container) {
        public void postLayout() {
             Rectangle diagramBounds = new PrecisionRectangle(container.getBounds());
             container.translateToAbsolute(diagramBounds);

             /*
              * Do the scale factor calculation based on you viewport/control size
              */

             ZoomManager zoomManager = (ZoomManager)DiuagramEditPart.this.getViewer().getProperty(ZoomManager.class.toString());
             if (zoomManager != null) {
                  zoomManager.setScale(scaleFactor);
             }
        }
    });
    return f;
}