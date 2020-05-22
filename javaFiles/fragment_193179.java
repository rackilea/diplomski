int mouseX2,lastMouseX2;

public Slashing(float x, float y, float z, int fillColor, float scale,
        PShape headAndFoot, PShape middle, PShape text, PApplet app) {
    super(x, y, z, fillColor, scale, headAndFoot, middle, text);
    this.app = app;
    // TODO Auto-generated constructor stub
    mouseX2 = (int) (app.mouseX * 0.245);
    lastMouseX2 = (int) (lastMouseX * 0.245);
}