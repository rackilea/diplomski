void setup()
{
  fullScreen(P3D);
  frameRate(1000);
  PJOGL pgl = (PJOGL)beginPGL();
  pgl.gl.setSwapInterval(1);
  endPGL();
}