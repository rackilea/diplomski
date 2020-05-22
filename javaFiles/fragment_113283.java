void sendDelete() throws IOException {
    CloseableHttpClient httpclient = HttpClients.createDefault();

    // create DELETE REQUEST
    HttpDelete httpDelete = new HttpDelete(
        "http://10.84.14.2:8082/virtual-network/47a91732-629b-4cbe-9aa5-45ba4d7b0e99");

    // add header "content-type"
    httpDelete.addHeader(new BasicHeader("Content-Type", "application/json; charset=UTF-8"));

    // send request
    CloseableHttpResponse response1 = httpclient.execute(httpDelete);

    // close response (ideally inside a finally clause in a try/catch)
    response1.close();

}