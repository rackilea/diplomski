public class Headers extends Action.Simple {

    public F.Promise<Result> call(final Http.Context ctx) throws Throwable {
        ctx.response().setHeader("Access-Control-Allow-Origin", "*"); 
        return delegate.call(ctx);
    }
}