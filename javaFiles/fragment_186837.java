@Bean
public InternalResourceViewResolver resolver() {
    InternalResourceViewResolver vr = new InternalResourceViewResolver();
    vr.setPrefix("/WEB-INF/jsps/");
    vr.setSuffix(".jsp");
    return vr;
}