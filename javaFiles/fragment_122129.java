public static void update(float elapsedTime){
    stateObject.update(elapsedTime);
}

public static void render(){
    stateObject.render();

    if (!stateObject.isCreated){

        switch (gameState){

            case START:
                stateObject = new StartScreen();
                break;
            case GAME:
                stateObject = new GameScreen();
                break;
            case LOADING:
                //stateObject = new LoadingScreen();
                break;
            default:
                System.out.print("ERROR IN STATE!");
                break;
        }//end switch

    }//end if

}//end render