//Login into Tremor Games and return the client(Saves the cookies).
private static WebClient tremorLogin(WebClient webClient) throws Exception
{
    webClient.getOptions().setJavaScriptEnabled(false);
    HtmlPage currentPage = webClient.getPage("http://www.tremorgames.com/"); //Load page at the STRING address.
    HtmlInput username = currentPage.getElementByName("loginuser"); //Find element called loginuser for username
    username.setValueAttribute(user); //Set value for username
    HtmlInput password = currentPage.getElementByName("loginpassword"); //Find element called loginpassword for password
    password.setValueAttribute(pass); //Set value for password
    HtmlSubmitInput submitBtn = currentPage.getElementByName("Submit"); //Find element called Submit to submit form.
    currentPage = submitBtn.click(); //Click on the button.

    return webClient;
}