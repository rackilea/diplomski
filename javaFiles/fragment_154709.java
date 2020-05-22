private void request(String geocode) throws IOException {
        HttpResponse response = Request.Post(SEARCH_URL).version(HttpVersion.HTTP_1_1)
                .bodyForm(createForm(geocode).build(), Charsets.UTF_8).useExpectContinue()
                .connectTimeout(CONNECTION_TIMEOUT_MILS)
                .socketTimeout(CONNECTION_TIMEOUT_MILS)
                .execute().returnResponse();

        assertStatus(response, geocode);
        getCoordinatesFromResponse(response, geocode);
    }

    private Form createForm(String geocode) {
        return Form.form().add("format", "json").add("results", "1").add("geocode", geocode);
    }

    private void assertStatus(HttpResponse response, String requestString) {
        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() >= ERROR_STATUS_MIN) {
            throw new RuntimeException(String.format(
                    "Error sending request '%s' to the map service, server response: %s",
                    requestString, response));
        }
    }