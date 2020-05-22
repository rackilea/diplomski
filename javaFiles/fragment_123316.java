@RequestMapping(value = "/large.csv", method = GET, produces = "text/csv")
@ResponseStatus(value = HttpStatus.OK)
public void streamLargeCSV(OutputStream out) {
    // Make an HTTP Request to http://application1/getbigcsv
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet("http://application1/getbigcsv");
    CloseableHttpResponse response = httpclient.execute(httpGet);
    try {
        HttpEntity entity = response.getEntity();
        // Return its response
        entity.writeTo(out);
    } finally {
        response.close();
    }
}