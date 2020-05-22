public class FetchCountryAction extends play.mvc.Action.Simple {

    public CompletionStage<Result> call(Http.Context ctx) {
        String host = ctx.request().host();
        String country = getCountry(host);
        ctx.args.put("country", country);
        return delegate.call(ctx);
    }

}