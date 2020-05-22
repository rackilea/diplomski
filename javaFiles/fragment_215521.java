try {
    URL oracle = new URL("http://oasth.gr/tools/lineTimes.php");
    HttpURLConnection yc = (HttpURLConnection) oracle.openConnection();

    yc.setRequestProperty("User-Agent",
            "Mozilla/5.0 (X11; Linux i686; rv:2.0b12) Gecko/20110222 Firefox/4.0b12");
    yc.setRequestProperty("Referer",
            "http://oasth.gr/tools/lineTimes.php");
    yc.setRequestProperty("Accept-Language",
            "el-gr,el;q=0.8,en-us;q=0.5,en;q=0.3");
    yc.setRequestProperty("Accept-Charset",
            "ISO-8859-7,utf-8;q=0.7,*;q=0.7");

    // content length should be 29 !!
    yc.setRequestProperty("Content-Length", "1000");

    // content length is 29 !
    String parames = "bline=63&goes=a&lineStops=886";

    yc.setDoOutput(true);

    OutputStreamWriter wr = new OutputStreamWriter(yc.getOutputStream());

    wr.write(parames);
    wr.flush();
    Log.d(TAG, "" + yc.getResponseCode());

    BufferedReader in = new BufferedReader(new InputStreamReader(
            yc.getInputStream()));
    String inputLine;

    StringBuilder sbu = new StringBuilder();

    while ((inputLine = in.readLine()) != null)
        sbu.append(inputLine);

    wr.close();
    in.close();

} catch (IOException e) {
    e.printStackTrace();
    Log.e("getLinesArrival Exception", e.getMessage());
}