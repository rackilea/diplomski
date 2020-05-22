function validateForm(event)
{
    event.preventDefault(); // this will prevent the submit event.
    if(document.loginform.username.value=="")
    {
      alert("User Name can not be left blank");
      document.loginform.username.focus();
      return false;
    }
    else if(document.loginform.password.value=="")
    {
      alert("Password can not be left blank");
      document.loginform.password.focus();
      return false;
    }
    else {
        document.loginform.submit();// fire submit event
    }
}