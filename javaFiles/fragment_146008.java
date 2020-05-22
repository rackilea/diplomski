SplashScreen splash = SplashScreen.getSplashScreen();
 if(splash != null)
 {
    try 
    {                
        Thread.sleep(2000); //Leave Splash up for 2 seconds
        splash.close();
    }
    catch(InterruptedException e) { LOG.log(Level.INFO, "Spash Sleep Interrupted", e); }
 }
 else
 {
    LOG.info("Splash Screen is null");
 }