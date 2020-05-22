@form(action = routes.Persons.update(), 'class -> "well well-lg form-horizontal") {
  <input type="hidden" name="email" value="@updateForm("email").value"/>
  <fieldset>
    @inputText(updateForm("forname"), '_label -> "First name", 'class -> "form-control")
    @inputText(updateForm("surname"), '_label -> "Last name", 'class -> "form-control")
    @inputText(updateForm("email"), '_label -> "Email", 'class -> "form-control", 'disabled -> "disabled")
    @inputPassword(updateForm("passwordHash"), '_label -> "Password", 'class -> "form-control")
  </fieldset>
  <button type="submit" class="btn btn-primary">Update</button>
}