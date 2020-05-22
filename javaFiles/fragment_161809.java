public class Global extends GlobalSettings {
    @Override
    public F.Promise<Result> onHandlerNotFound(Http.RequestHeader request) {

        return JPA.withTransaction(new F.Function0<F.Promise<Result>>() {
            @Override
            public F.Promise<Result> apply() throws Throwable {
                return F.Promise.pure(Application.pageNotFound());
            }
        });

    }
}