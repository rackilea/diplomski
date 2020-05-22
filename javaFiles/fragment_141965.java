public void onNmeaReceived(long timestamp, String nmea) 
        { 
            String params;
            try {
                params = URLEncoder.encode(nmea, "UTF-8");
                Log.d("executing", params);
                String url = "http://www.xyz.com/server.php?DATA="+params;
                //url = url+params;
                HttpPost httppost = new HttpPost(url);
                HttpClient client = new DefaultHttpClient();
                try {
                    HttpResponse httpResponse = client.execute(httppost);
                    Log.d("Status", "Request Sent " + httpResponse.getStatusLine().getStatusCode());
                    } 
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    } 
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

<?php 
$data = $_GET["DATA"]."";
echo urldecode($data);
//$data = file_get_contents('php://input');
$Handle = fopen("xxx/xxx/test.nmea", "a");
fwrite($Handle, $data);
fclose($Handle);
flush($Handle);
?>