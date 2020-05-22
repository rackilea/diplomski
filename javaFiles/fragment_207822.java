<form class="form-signin"name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
    <fieldset>
            <input class="form-control form-group" type="text" name="username" placeholder="Username">
            <input class="form-control" type="password" name="password" placeholder="Password" >
            <a class="forgot pull-right" href="#">Forgot password?</a>
            <button name="submit" class="btn btn-block btn-primary" type="submit">Sign in</button>
    </fieldset>
</form>