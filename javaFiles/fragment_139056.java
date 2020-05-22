public class SecurityPostProcessingFilter extends Filter {
    public SecurityPostProcessingFilter(
              Context context, Restlet next) {
        super(context, next);
    }

    @Override
    protected void afterHandle(Request request, Response response) {
        String requestedWith
           = request.getHeaders().getFirstValue("X-Requested-With");
        if ("XMLHttpRequest".equals(requestedWith)) {
            response.getChallengeRequests().clear();
        }
    }
}