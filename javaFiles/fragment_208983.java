public class ResponseEncoder extends GsonDecoder {

    public ResponseEncoder() {
        super();
    }
    @Override
    public Object decode(Response response, Type type) throws IOException
    {
        Class<?> clazz = (Class<?>) type; 
        ResponseSimple<?> response = createResonse(clazz); 

        return null;
    }

}