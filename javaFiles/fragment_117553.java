@Override
protected String doInBackground(Object... params) {
    // TODO Auto-generated method stub
    String strresult="";
    try {
        Log.i("my label", "entering in doInBackground");
        Log.i("params[0]", params[0].toString());
         strresult= QueryYahooWeather(params[0].toString());
         Log.i("strresult result ::: ", strresult);

    } catch (Exception e) {
        Log.i("my label", e.toString());
        return null;
    }
 return strresult;
}