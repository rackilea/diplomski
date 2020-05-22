// from Undertow 1.1.0-final 
// http://grepcode.com/file/repo1.maven.org/maven2/io.undertow/undertow-servlet/1.1.0.Final/io/undertow/servlet/spec/HttpServletResponseImpl.java#HttpServletResponseImpl.getHeader%28java.lang.String%29
@Override
public Collection<String> getHeaders(final String name) {
   HeaderValues headers = exchange.getResponseHeaders().get(name);
    if(headers == null) {
        return Collections.emptySet();
    }
    return new ArrayList<>(headers);
}