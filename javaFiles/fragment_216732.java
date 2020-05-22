function submitLoginForm()
{
    var hiddenSubmitBtn = document.getElementById("hiddenSubmitButton");
    if(hiddenSubmitBtn.click) {
        hiddenSubmitBtn.click();
    } else {
        document.loginform.submit();
    }
    return false;
}