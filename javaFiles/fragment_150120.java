/**
* this class is required to use our custom path variable validation on 
* the controller class
*/
@Configuration
class ValidatorConfiguration {

    @Bean
    MethodValidationPostProcessor methodValidationPostProcessor() {
    return new MethodValidationPostProcessor()
    }
}