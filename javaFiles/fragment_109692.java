private SimpleUniverse my_space = null;
public void init()
{
   System.out.println(" started! ");
   GraphicsConfiguration GC_me = SimpleUniverse.getPreferredConfiguration();
   Canvas3D Canvas_me = new Canvas3D(GC_me);
   my_space = new SimpleUniverse(Canvas_me);
   setLayout(new BorderLayout());
   add("Center", Canvas_me);
}