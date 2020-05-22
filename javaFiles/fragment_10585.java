class ExtraParamSource implements AuthenticationDetailsSource<HttpServletRequest, ExtraParam> {

public ExtraParam buildDetails (HttpServletRequest context) {

return new ExtraParam(context);
}
}