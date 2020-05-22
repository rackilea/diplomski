public boolean checkAndroidData(){
    final boolean[] result = {false};
    handler.post(new Runnable() {
            @Override
            public void run() {
                // Android code here
                // I need know the value of this variable
                result[0] = true;
            }
    });
    return result[0];
}