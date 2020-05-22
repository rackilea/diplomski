@Slf4j
public class MyCustomResponseErrorHandler implements ResponseErrorHandler {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() != HttpStatus.OK) {
            log.info("loggin stuff");
            return true;
        }
    return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws     JsonParseException, JsonMappingException, IOException{
        if (response.getStatusCode() != HttpStatus.OK) {
            log.info("logging stuff");
            throw new RestErrorExeption(mapper.readValue(response.getBody(),     RESTError.class));
        }
    }
}