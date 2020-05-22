@helper.form(action = routes.User.loginSubmit()) {
    <input type="text" name="username" /><br/>
    <input type="password" name="password" /><br/>

    <input type="submit" value="Login" />
}