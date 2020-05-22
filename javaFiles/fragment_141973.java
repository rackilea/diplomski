public static Promise<Result> myMethod() {
    JsonNode json = request().body().asJson();
    if (json == null) {
        Logger.info("bad json request");
        return badRequest();
    }

    RegistrationHandler registrationHandler = new RegistrationHandler();
    if(!registrationHandler.isEmailUnique(json)) {
        return ok("false");
    }

    registrationHandler.saveUser(json);
    String email = json.findValue("email").asText();
    F.Promise<Boolean> emailPromise = F.Promise.promise(
        new F.Function0<Boolean>() {
        public Boolean apply() {
            // This method takes a while
            return sendRegistrationEmail(email);
        }
    });

    return emailPromise.map(new Function<Boolean, Result>() {
        public Result apply(Boolean successful) {
            if (successful) {
                return ok("success");
            } else {
                return ok("error");
            }
        } 
    });
}