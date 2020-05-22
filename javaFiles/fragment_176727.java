public static Result recoverPassword() {
    Form<RecoveryForm> resetForm = form(RecoveryForm.class);

    if (!successfullPaswordChange){
        return badRequest(recover.render(resetForm, false));
    }

    return ok(recover.render(resetForm, true));
}