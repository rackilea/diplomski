protected boolean navigationClick(int status, int time) {

    // Push screen 
    MyScreen myScreen = new myScreen();
    UiApplication.getUiApplication().pushScreen( myScreen );

}