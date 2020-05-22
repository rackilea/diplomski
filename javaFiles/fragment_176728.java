public static Result recoverPassword() {
    ...
    if (!successfullPaswordChange){
        return badRequest(recover.render(resetForm, false));
    }

    flash("passchange.succces", "Your password was reseted, check your mail");
    return redirect(routes.Application.index());
}