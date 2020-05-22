try {
    HttpClient client = new DefaultHttpClient();  
    String getURL = "http://busspur02.aseag.de/bs.exe?SID=5FC39&ScreenX=1440&ScreenY=900&CMD=CR&DatumT="+day+"&DatumM="+month+"&DatumJ="+year+"&ZeitH="+hour+"&ZeitM="+min+"&Intervall=120&Suchen=(S)uchen&GT0=Aachen&T0=H&HT0="+start_from+"&GT1=Aachen&T0=H&HT1="+destination+"";
    HttpGet get = new HttpGet(getURL);
    HttpResponse responseGet = client.execute(get);  
    HttpEntity resEntityGet = responseGet.getEntity();  
    String sourceString = "";

    if (resEntityGet != null) {                 
        try {
            dismissDialog();
            sourceString= new String(EntityUtils.toString(resEntityGet));
            Log.i("GET RESPONSE", sourceString);
        } catch (ParseException exc) {
            // TODO Auto-generated catch block
            exc.printStackTrace();
        } catch (IllegalStateException exc) {
            // TODO Auto-generated catch block
            exc.printStackTrace();
        }
        ...
    }
    ...
} catch(...) {
...
}