@Bean
public Filter ajaxTimeOutRedirectFilter() {
    AjaxTimeOutRedirectFilter f = new AjaxTimeOutRedirectFilter();
    //f.setCustomSessionExpiredErrorCode(901);
    return f;
}
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .addFilterAfter(ajaxTimeOutRedirectFilter(), ExceptionTranslationFilter.class)
        ...
        ...
}