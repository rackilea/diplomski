public ManageService() {
    keyboard = new NativeKeyBoard();
    //make ManageService as an parameter to create a thread
    service = new Thread(this,"Manage Service");
    service.start();
}