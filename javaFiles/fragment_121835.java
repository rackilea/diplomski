Protocol.registerProtocol("vhttps", new Protocol("vhttps", new ValicertSSLProtocolSocketFactory(), 443));
PostMethod postMethod = new PostMethod(url);
for (Map.Entry<String, String> entry : params.entrySet()) {
    postMethod.addParameter(entry.getKey(), StringUtils.Nz(entry.getValue()));
}

HttpClient client = new HttpClient();
int status = client.executeMethod(postMethod);
if (status == 200) {
    StringBuilder resultBuffer = new StringBuilder();
    resultBuffer.append(postMethod.getResponseBodyAsString());
    return new HttpResponse(resultBuffer.toString(), "");
} else {
    throw new IOException("Invalid response code: " + status);
}