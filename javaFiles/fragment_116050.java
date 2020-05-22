public static void setScreen(Screen screen){
    if(currentScreen != null){
        currentScreen.dispose();
        System.out.println("Screen disposed");
    }
    currentScreen = screen;
    currentScreen.getGameCore().setScreen(currentScreen);
}