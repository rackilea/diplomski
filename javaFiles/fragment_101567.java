public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
    if (/* your condition */) {
       return delegate.call(ctx);
    } else {
       return F.Promise.pure(redirect(routes.AdminController.login()));
    }
}