public static String[] UploadUserProfilePicture(FileToUpload fileToUpload) {

StringBuilder sb = new StringBuilder();
String result[] = {"false", "Something went wrong"};

HttpURLConnection urlConnection = null;
try {
    URL url;
    DataOutputStream printout;
    DataInputStream input;
    url = new URL(LOCATION + "/UploadUserProfilePicture");
    urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.setDoInput(true);
    urlConnection.setDoOutput(true);
    urlConnection.setUseCaches(false);
    urlConnection.setRequestProperty("Content-Type", "application/json");
    urlConnection.setRequestProperty("Host", "x.x.x.x:xxxx");
    urlConnection.setConnectTimeout(1*1000*3600);
    urlConnection.setReadTimeout(1*1000*3600);
    urlConnection.connect();

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    // Send POST output.
    printout = new DataOutputStream(urlConnection.getOutputStream());
    byte[] extraInfo = gson.toJson(fileToUpload).getBytes("UTF-8");
    printout.write(extraInfo);
    printout.flush();
    printout.close();

    int HttpResult = urlConnection.getResponseCode();  
    if (HttpResult == HttpURLConnection.HTTP_OK) {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream(), "utf-8"));
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        result = CommonMethods.parseJsonToArray(sb.toString());

    } else {
        System.out.println("*** RESPONSE MESSAGE ***");
        System.out.println(urlConnection.getResponseMessage());
    }
    return result;
} catch (MalformedURLException e) {

    e.printStackTrace();
} catch (IOException e) {

    e.printStackTrace();
} finally {
    if (urlConnection != null)
        urlConnection.disconnect();
}
return null;
}