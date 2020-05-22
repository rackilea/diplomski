private void putPageUnderRootAisleId() {
    return putPageUnderAisleId(null);
}

private void putPageUnderAisleId(String aisleId) {
    Object putKey = aisleId != null ? AISLE_HTML_URL : ROOT_AISLE_HTML_URL;
    Object[] putArgs = aisleId != null ? new Object[]{aisleId} : new Object[]{};

    given()
            .spec(prepareApplicationJsonHeaders())
            .header(HttpHeaders.AUTHORIZATION, verifiableToken(Roles.WRITE_MERCHANDISING))
            .body(readResource(NAMED_PAGE_CONTENT_FILE, String.format("%s.html", TEST_PAGE.value()), AISLE_TEST_LOCATION))
            .put(putKey, putArgs)
            .then()
            .statusCode(200)
            .body(not(isEmptyOrNullString()))
            .body(JSON_RESPONSE_MESSAGE, not(isEmptyOrNullString()));
}