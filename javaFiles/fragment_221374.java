public void tryingOkHttpClientPostt(String accessToken) {
    OkHttpClient client = new OkHttpClient();
    HttpUrl.Builder urlBuilder = HttpUrl.parse("https://graph.microsoft.com/v1.0/me/sendMail").newBuilder();
    String json = "{" + "'Message': {" + "'Subject': 'Meet for lunch?'," + "'Body': {" + "'ContentType': 'Text',"
            + "'Content': 'The new cafeteria is open.'" + "}," + "'ToRecipients': [{" + "'EmailAddress': {" + "'Address': 'myMail@gmail.com'" + "}" + "}"
            + "]," + "'Attachments': [{" + "'@odata.type': '#Microsoft.OutlookServices.FileAttachment'," + "'Name': 'menu.txt',"
            + "'ContentBytes': 'bWFjIGFuZCBjaGVlc2UgdG9kYXk='" + "}" + "]" + "}," + "'SaveToSentItems': 'false'" + "}";
    RequestBody body = RequestBody.create(JSON, json);
    String url = urlBuilder.build().toString();
    Request request = new Request.Builder().header("Content-Type", "application/json")
            .header("Authorization", String.format("Bearer %s", accessToken)).method("POST", body).url(url).build();
    try {
        Response response = client.newCall(request).execute();
    } catch (IOException e) {
        e.printStackTrace();
    }
}