public class RestTemplateClientErrorHandler implements ResponseErrorHandler {

private static final Logger logger = LoggerFactory.getLogger(RestTemplateClientErrorHandler.class);

@Override
public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
    return RestUtil.isError(clientHttpResponse.getStatusCode());
}

@Override
public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
    String responseBody = "";
    if(clientHttpResponse != null && clientHttpResponse.getBody() != null){
        responseBody = IOUtils.toString(clientHttpResponse.getBody());
    }
    switch(clientHttpResponse.getRawStatusCode()){
        case 404:
            logger.error("Entity not found. Message: {}. Status: {} ",responseBody,clientHttpResponse.getStatusCode());
            throw new RestClientResponseException(responseBody);
        case 400:
            logger.error("Bad request for entity. Message: {}. Status: {}",responseBody, clientHttpResponse.getStatusCode());
            throw new RestClientResponseException(StringUtils.EMPTY, 400,StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
        default:
            logger.error("Unexpected HTTP status: {} received when trying to delete entity in device repository.", clientHttpResponse.getStatusCode());
            throw new RestClientResponseException(responseBody);
    }

}

public static class RestUtil {

    private RestUtil() {
        throw new IllegalAccessError("Utility class");
    }

    public static boolean isError(HttpStatus status) {
        HttpStatus.Series series = status.series();
        return HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series);
    }
}
}