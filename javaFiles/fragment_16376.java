HttpPost request = new HttpPost(URL);
   request.setHeader("Accept", "application/json");
   request.setHeader("Content-type", "application/json");
   JSONStringer vm;
   try {
         vm = new JSONStringer().object().key("function")
        .value(login).key("parameters").object()
        .key("username")
        .value(nithin).key("password").value("123456")
        .endObject().endObject();
  StringEntity entity = new StringEntity(vm.toString());
  request.setEntity(entity);
  HttpClient httpClient = new DefaultHttpClient();
  HttpResponse response = httpClient.execute(request);