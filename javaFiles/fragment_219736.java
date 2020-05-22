@Override
public void addInterceptors (InterceptorRegistry registry) {
    LocaleChangeInterceptor l = new LocaleChangeInterceptor();
    l.setParamName("localeCode");
    registry.addInterceptor(l);
}