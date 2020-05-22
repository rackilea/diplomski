public URIBuilder removeQuery() {
    this.queryParams = null;
    this.query = null; // <- this is the only difference
    this.encodedQuery = null;
    this.encodedSchemeSpecificPart = null;
    return this;
}