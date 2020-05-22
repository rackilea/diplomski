URL url = new URL(file_url);
 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
 int code = connection.getResponseCode();

    if(code == 200) {
    // reachable
    } else {
    }