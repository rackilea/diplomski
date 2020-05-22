class HTTPAccess{
    private RestTemplate restTemplate;
    private DataKey key;

    public HTTPAccess(DataKey key,RestTemplate restTemplate){
        this.key = key;
        this.restTemplate = restTemplate;

    }


    public DataResponse performRequest() {
        DataResponse dataResponse = null;        
        try {
            String url = createURL();
            response = restTemplate.getForObject(url, String.class);

            // it is a successful response
            dataResponse = new DataResponse(response, DataErrorEnum.NONE, DataStatusEnum.SUCCESS);
        } catch (RestClientException ex) {
            PotoLogging.logErrors(ex, DataErrorEnum.SERVER_DOWN, key);
            dataResponse = new DataResponse(null, DataErrorEnum.SERVER_DOWN, DataStatusEnum.ERROR);
        } catch (Exception ex) {
            PotoLogging.logErrors(ex, DataErrorEnum.CLIENT_ERROR, key);
            dataResponse = new DataResponse(null, DataErrorEnum.CLIENT_ERROR, DataStatusEnum.ERROR);
        }

        return dataResponse;
    }

    // create a URL by using key object
    private String createURL() {
        String url = somecode;
        return url;
    }

}