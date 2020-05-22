public class SecondVM {
  public static void main(String[] args)  {
    if (    System.getenv("SWT_GTK3") == null
         || System.getenv("LIBOVERLAY_SCROLLBAR") == null )  
    { 
      URL classResource = SecondVM.class.getResource("SecondVM.class");
      boolean fromJar = classResource.getProtocol().equals("rsrc");

      String exePath = ClassLoader.getSystemClassLoader().getResource(".").getPath();
      exePath =  new File(exePath).getAbsolutePath().replaceFirst("\\.$", "").replaceFirst("bin$", "");
      if (!exePath.endsWith(System.getProperty("file.separator")))
        exePath += System.getProperty("file.separator");

      String[] script = {
          "/bin/bash", "-c",
          "export SWT_GTK3=0; "
           + "export LIBOVERLAY_SCROLLBAR=0; "
           + (fromJar? // TODO: Put the proper paths, packages and class names here
              "java -jar " + exePath + "SecondVM.jar" :         // if runs from jar
              "java -cp ./bin/:../ExtLibs/swt_linux64/swt.jar " // if runs from under Eclipse or somewhat alike 
              + "com.m_v.test.SecondVM")
      };

      try {
        Process p = new ProcessBuilder(script).start();

        // When jar is run from a bash script, it kills the second VM when exits.
        // Let it has some time to take a breath
        p.waitFor(12, TimeUnit.HOURS);
      } catch (Exception e) { e.printStackTrace(); }
      System.exit(0);
    }

    // Now the env vars are OK. We can use SWT with normal scrollbars    
    Display display = Display.getDefault();
    // .... do watever we need 
  }
}