public class SearchBuilder {
  private URI baseUri;
  private List<NameValuePair> parameters;

  public SearchBuilder (URI baseUri) {
    this.baseUri= baseUri;
    this.parameters = new ArrayList<NameValuePair>();
  }

  public void addSearchParam1(String val) { 
    if(!StringUtils.isBlank(val)) {
      parameters.add(new BasicNameValuePair("SearchParam1", val));
    }
  }

  //Form the query url
  public URI toURI(){
    URI uri = URIUtils.createURI(baseUri.getScheme(), baseUri.getHost(), baseUri.getPort(), baseUri.getPath(), URLEncodedUtils.format(parameters, "UTF-8"), null);
    return uri;
  }