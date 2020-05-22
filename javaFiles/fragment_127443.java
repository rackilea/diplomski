NetworkManager.callServer("serverurl", new OnComplete() {
    @Overwrite        
    void onComplete() {
        //Do your stuff here
    }
    @Overwrite
    void onError(String errorMsg){
    }
}