public static void main(String[] args)
   {
      // Create a new instance of the application and make the currently
      // running thread the application's event dispatch thread.
      try {
         String[] params = StringUtils.split(args[0], " ");
         MyApp theApp = new MyApp();