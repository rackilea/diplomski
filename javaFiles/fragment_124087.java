public class VerboseAction extends play.mvc.Action.Simple {

    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        Promise<Result> call;
        try {
            call = delegate.call(ctx);
        } catch (Exception e) {
            Logger.error("Exception during call " + Controller.request().uri()
                    + ": " + e.getMessage(), e);
            call = Promise.<Result> pure(redirect(controllers.routes.Home
                    .error(e.getMessage())));
        }
        return call;
    }
}