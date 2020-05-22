public class MyTransformer extends ResponseTransformer {

    @Override
    public Response transform(final Request request,
                              final Response response,
                              final FileSource fileSource,
                              final Parameters parameters){
        HttpHeaders headers = new HttpHeaders(new HttpHeader("Content-Type", "application/json"));
        if(request.getUrl().contains("/rest")){
            ...
            return Response.Builder.like(response).but().body(...).headers(headers).build();
        } else
            return Response.Builder.like(response).but().status(404).headers(headers).build();
    }

    @Override
    public String getName() {
        return "swapper";
    }
}