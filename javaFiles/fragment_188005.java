String url = "https://api.parse.com/1/functions/sendEmailNow";
    URL obj = new URL(url);

    //Attempt to use HttpRequest to send post request to parse cloud
    HttpRequest request = HttpRequest.post(obj).contentType("application/json");
    request.header("X-Parse-Application-Id", "**************************");
    request.header("X-Parse-REST-API-Key", "********************");
    JSONObject jsonParam = new JSONObject();
    jsonParam.put("emailId", emailId);
    request.send(jsonParam.toString().getBytes("UTF8"));

    if (request.ok())
        System.out.println("HttpRequest WORKED");
    else
        System.out.println("HttpRequest FAILED " + request.code() + request.body());