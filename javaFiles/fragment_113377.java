@Configuration
@PropertySource("classpath:application.properties")
public Class Util(){

    @Bean
    public Weather weatherService(){
        WeatherService_Service  =  new WeatherService_Service(wsdlURL, new QNAME("urn value",Weather)
        endpoint  =  service.getBasicHttpBindingWeather;
        return endpoint
    }
}