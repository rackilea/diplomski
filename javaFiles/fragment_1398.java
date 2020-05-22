1. static final Screen screen = Screen.getInstance();
2. public static GameManager getInstance(){ return manager;}
3. private static final GameManager manager = new GameManager();
4. private GameManager(){
    //......
    screen.addListener(listener);
    //but screen is still null !!! NullPointerException !!!
}