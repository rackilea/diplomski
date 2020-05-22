public Action onRequest(final Http.Request request, final Method actionMethod) {

    if (request.host().equals("de.yourdomain.tld")
            && (request.cookie("PLAY_LANG") == null || !request.cookie("PLAY_LANG").value().equals("de"))) {
        return new Action.Simple() {
            public Result call(Http.Context ctx) throws Throwable {
                ctx.changeLang("de");
                return redirect(request.path());
            }
        };
    } else {
        return super.onRequest(request, actionMethod);
    }
}