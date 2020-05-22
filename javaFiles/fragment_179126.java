if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(pass) && StringUtils.isNotBlank(cpass)) {

    forwardJsp = "/SignUpMoreInfo.jsp";

} else {

    request.setAttribute("signupFieldWasEmpty", true);

    response.sendRedirect("/Home");
}