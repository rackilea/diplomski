@Override
protected Void doInBackground(Void... params) {
    try {
        Document document = Jsoup.connect(url).get();              
    } catch (IOException e) {
        e.printStackTrace();
    }
    Elements elem = null; 
    elem = document.select("*");
    Log.i("Value of elem", String.valueOf(elem);
    return null;
}