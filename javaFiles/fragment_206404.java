<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <script>
        function check(form, button){
            if(button.id=='login'){
                form.action="Login";
            }else if(button.id=='create'){
                form.action="Create";
            }
            form.submit();
        }
    </script>
    <title>Insert title here</title>
    </head>
    <body>
        <form name="loginForm" method="post">
            <table width="20%" bgcolor="0099CC" align="center">
                <tr>
                    <td colspan=2>
                        <center>
                            <font size=4><b>HTML Login Page</b></font>
                        </center>
                    </td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" size=25 name="username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="Password" size=25 name="password"></td>
                </tr>
                <tr>
                    <td><input type="button" id="login" onclick="check(this.form,this)"
                        value="Login"></td>
                </tr>
                <tr>
                    <td><input type="button" id="create" onclick="check(this.form,this)"
                        value="Create profile"></td>
                </tr>

            </table>
        </form>
    </body>
</html>