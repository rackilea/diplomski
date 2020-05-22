private void sendStuff(Context context, String[] params) {
    final int TIMEOUT = 2000;

    RESTGet restGet = new RESTGet(context);
    restGet.setMessageLoading("Loading...");
    try {
        restGet.execute(params).get(TIMEOUT, TimeUnit.MILLISECONDS);
    } catch (Exception e) {
        e.printStackTrace();
    }
    restGet.stopMessageLoading();
    Intent intent = new Intent(context, ShowPictures.class);
    ((Activity)context).startActivity(intent);
}