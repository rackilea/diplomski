Controller:
public static Result create() {
    Form<Computer> computerForm = form(Computer.class);
    return ok(
        createForm.render(computerForm)
    );
}

View:
@inputText(computerForm("name"), '_label -> "Computer name")
@inputText(computerForm("introduced"), '_label -> "Introduced date")
@inputText(computerForm("discontinued"), '_label -> "Discontinued date")