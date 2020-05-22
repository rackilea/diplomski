//Get the splashscreen
final SplashScreen splash = SplashScreen.getSplashScreen();

//Close splashscreen
    if (splash != null) {
        System.out.println("Closing splashscreen...");
        splash.close();
    }