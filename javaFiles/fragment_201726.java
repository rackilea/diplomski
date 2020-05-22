function validate(){
    var username = document.getElementById("userName").value;
    var password = document.getElementById("passWord").value;
}


<form id="loginform" action="login.do" method="post">
    UserName:<html:text property="userName" styleId="userName"></html:text>
    PassWord:<html:password property="passWord" styleId="passWord"></html:password>
    <html:button onclick="validate()"></html:button>
</form>