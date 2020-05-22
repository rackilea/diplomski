public void start()
    {

       try
       {
           String serverCfgFile = Utils.getIstatsHome() + jettyConfig;
           File f = new File(serverCfgFile);
           if (!f.exists())
           {
               throw new Exception("Jetty conf file " + serverCfgFile + " not found");
           }

           server = new Server(7070);

           XmlConfiguration configuration = new XmlConfiguration(new FileInputStream(f));
           configuration.configure(server);
           server.start();
       }
 catch (Exception ex)
   {
        _logger.log(Constants.EXCEPTION_LEVEL, "", ex);
   }
    }