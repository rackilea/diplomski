public static Result getVersion(double var) {
    if (var != ConfigFactory.load().getDouble("version")) {
        return redirectTo();
    }
    return ok("version -> " + var);
}


public static Result redirectTo() {
    return redirect(controllers.routes.Application.getVersion(ConfigFactory.load().getDouble("version")));
}