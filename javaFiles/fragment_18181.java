private String generateLoginPageHtml(HttpServletRequest request, boolean loginError, boolean logoutSuccess) {
    String errorMsg = "none";

    [...]

    StringBuilder sb = new StringBuilder();

    sb.append("<html><head><title>Login Page</title></head>");

    if (formLoginEnabled) {
        sb.append("<body onload='document.f.").append(usernameParameter).append(".focus();'>\n");
    }

    [...]