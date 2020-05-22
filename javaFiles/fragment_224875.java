int width = 0;
int height = 0;
GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice[] gs = ge.getScreenDevices();
for (GraphicsDevice curGs : gs)
{
  DisplayMode mode = curGs.getDisplayMode();
  width += mode.getWidth();
  height = mode.getHeight();
}