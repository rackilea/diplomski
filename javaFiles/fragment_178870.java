public void init() throws ServletException{
      String contextPath=getServletContext().getRealPath("/");
      File tomcatHome=new File(contextPath).getParentFile().getParentFile();
      File configFile=new File(tomcatHome,"conf_location.txt");
      try {
          String config_location = new Scanner(configFile).useDelimiter("\\Z").next();
      } catch (Exception e) {}
  }