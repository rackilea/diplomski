try
{
   GraphicsConfigTemplate3D gconfigTemplate = new GraphicsConfigTemplate3D();
   GraphicsConfiguration config = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getBestConfiguration(gconfigTemplate);
}
catch (Error e) // You shouldn't normally catch java.lang.Error... this is an exception
{
   System.out.println("Java3D binaries not installed");
}