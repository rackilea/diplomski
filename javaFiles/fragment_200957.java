@Configuration
public class AppConfiguration { 
    @Bean
    public JQueryArrayParameterFilter jQueryArrayParameterFilter() {
        return new JQueryArrayParameterFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(JQueryArrayParameterFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns( "/datatables/*");
        return filterRegistrationBean;
    }
}