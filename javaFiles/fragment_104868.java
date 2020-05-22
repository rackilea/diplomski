public class HeaderAwareJsonRequest extends Request<Pair<JSONObject,Map>> {
  protected Response.Listener<Pair<JSONObject,Map>> listener;

  public HeaderAwareJsonRequest( int method, String url, Response.Listener<Pair<JSONObject,Map>> listener, Response.ErrorListener errorListener ) {
    super( method, url, errorListener );
    this.listener = listener;
  }

  @Override
  protected Response<Pair<JSONObject,Map>> parseNetworkResponse( NetworkResponse response ) {
    try{
      String jsonString = new String( response.data, HttpHeaderParser.parseCharset( response.headers ) );
      // pair contains the json body and headers 
      Pair pair = new Pair( new JSONObject( jsonString ), response.headers );
      return Response.success( pair, HttpHeaderParser.parseCacheHeaders( response ) );
    }catch( Exception e ){
      return Response.error( new ParseError( e ) );
    }
  }    
}