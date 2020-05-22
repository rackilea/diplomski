JFrame frame = new JFrame();
Canvas canvas = new Canvas();
frame.add(canvas);
frame.setVisible(true);
try 
{
    Display.setParent(canvas);
    Display.create();
} 
catch (LWJGLException e) 
{
    e.printStackTrace();
}