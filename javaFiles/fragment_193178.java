public Slashing(float x, float y, float z, int fillColor, float scale,
        PShape headAndFoot, PShape middle, PShape text, PApplet app) {
    super(x, y, z, fillColor, scale, headAndFoot, middle, text);
    this.app = app;
    // TODO Auto-generated constructor stub

}
int mouseX2 = (int) (app.mouseX * 0.245);
int lastMouseX2 = (int) (lastMouseX * 0.245);