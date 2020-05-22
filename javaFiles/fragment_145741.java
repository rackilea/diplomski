public void postData() {
    String fullUrl = "https://docs.google.com/forms/d/1Ee330GpkMHX_0dKWmJb6ZPdm4FBhhqJSqBbgysEtq6M/formResponse";
    HttpRequest mReq = new HttpRequest();
    String response = mReq.sendPost(fullUrl, "entry.1566150510=data");
    Log.i(myTag, response);
}