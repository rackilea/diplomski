//here we are making property values as fields of custom bean
//now property values will be accessed in a way, as field of some ordinary java bean
@Configuration
public class NewConfig {

 @Bean
 NewProps newProps(){
    return new NewProps();
 }
}