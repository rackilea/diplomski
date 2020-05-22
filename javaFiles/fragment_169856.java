class LoginTask extends AsyncTask<String,Void,Void>
{
    @Override
    protected Void doInBackground(String... params) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON); 
        HttpEntity<String> _entity = new HttpEntity<String>(requestHeaders);
        RestTemplate templ = new RestTemplate();
        templ.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        templ.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        ResponseEntity<String> _response = templ.postForEntity(params[0],_entity,null) //null here in order there wasn't http converter errors because response type String and [text/html] for JSON are not compatible;
        String _body =  _response.getBody();
        return null;
    }
}