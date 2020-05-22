@Configuration
class MyConfiguration {
    @Bean
    public CustomInterface customInterface(MySettings mySettings) {
        return (CustomInterface) Class.forName(mySettings.getCustomTypeField()).newInstance();
    }
}