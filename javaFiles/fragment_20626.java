Webb webb = Webb.create();
String result = webb.post("http://my-server/path/resource")
    .header("auth-token", myAuthToken)
    .body(myBody)
    .ensureSuccess()
    .asString()
    .getBody();