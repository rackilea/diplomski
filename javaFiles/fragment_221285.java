public static void setScreen(Screen screen){
    if(currentScreen != null){
        currentScreen.dispose();
        currentScreen = screen;
        currentScreen.create();
    }
}