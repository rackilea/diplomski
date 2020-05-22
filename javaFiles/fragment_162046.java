@Provider
@Produces( { "application/javascript", "application/x-javascript" } )
public class JsonMessageBodyWriter extends MOXyJsonProvider
{

    private static final MediaType APPLICATION_JAVASCRIPT = new MediaType( "application", "javascript" );
    private static final MediaType APPLICATION_XJAVASCRIPT = new MediaType( "application", "x-javascript" );

    @Context
    private HttpServletRequest httpRequest;


    @Override
    protected boolean supportsMediaType( MediaType mediaType )
    {
        if( mediaType.equals( APPLICATION_JAVASCRIPT ) ||
              mediaType.equals( APPLICATION_XJAVASCRIPT ) )
            return true;
        return false;
    }


    @Override
    public void writeTo( Object object, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
          MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream ) throws IOException, WebApplicationException
    {

        String callback = httpRequest.getParameter( "callback" );
        if( callback == null )
            callback = "callback";

        entityStream.write( callback.getBytes() );
        entityStream.write( "(".getBytes() );
        super.writeTo( object, type, genericType, annotations, mediaType, httpHeaders, entityStream );
        entityStream.write( ")".getBytes() );
    }

}