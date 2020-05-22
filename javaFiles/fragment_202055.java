// from Undertow 1.0.15-final 
// http://grepcode.com/file/repo1.maven.org/maven2/io.undertow/undertow-servlet/1.0.15.Final/io/undertow/servlet/spec/HttpServletResponseImpl.java#HttpServletResponseImpl.getHeaders%28java.lang.String%29
@Override
public Collection<String> getHeaders(final String name) {
    return new ArrayList<String>(exchange.getResponseHeaders().get(name));
}