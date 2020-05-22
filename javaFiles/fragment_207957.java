@Override
public void onResponse(String response) {
    // String response = "hello{\"key\":\"value\"}world"; if you response like this 
    try {
        if (response != null) {
            JSONObject jsonResponse = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
            // do something here
            Log.e("TAG", response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}