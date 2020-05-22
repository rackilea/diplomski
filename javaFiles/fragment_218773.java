private static final String SHADE = "shadedcolor";

Color color = null;
if (!JFaceResources.getColorRegistry().hasValueFor(SHADE)) {
    color = new Color(Display.getCurrent(), shade, 255-shade, 0);
    JFaceResources.getColorRegistry().put(SHADE, color);
} else {
    color = JFaceResources.getColorRegistry().get(SHADE);
}