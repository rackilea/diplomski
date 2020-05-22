public HomePage fillFirstName(String firstName)
{
    name.sendKeys(firstName);

    return this;
}

public HomePage fillEmail(String email)
{
    email.sendKeys(email);

    return this;
}

public void fillPass(String pass)
{
    password.sendKeys(pass);
}