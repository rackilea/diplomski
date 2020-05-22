public void checkAndroidData(Listener<Boolean> onCompleteListener){
    handler.post(new Runnable() {
            @Override
            public void run() {
                onCompleteListener.on(true);
            }
    });
}