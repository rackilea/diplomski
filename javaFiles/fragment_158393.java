#{extends 'main.html' /}
#{set title:'Create User' /}
<form action="@{UserController.insertUser(user)}" method="POST"/>
    Username: <input type="text" name="user.username" value="${user.username}" /><br/>
    Password: <input type="text" name="user.password" value="${user.password}" /><br/>
    Email: <input type="text" name="user.email" value="${user.email}" /><br/>
    <input type="submit" value="Add User" />
</form>