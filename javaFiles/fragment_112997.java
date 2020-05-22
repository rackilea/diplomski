// For configuration aspects important for 1 project in particular
package com.appone.pkg.three

@Configuration
@EnableJpaRepositories("com.pkg.three.jpa.repository")
@EntityScan("com.pkg.three.jpa.model")
public class AppTwoConfig {

    @Bean
    GroupValidator groupValidator(){
        return new GroupValidator();
    }
    @Bean
    UserValidator userValidator(){
        return new UserValidator();
    }
    @Bean
    ResourceMapper resourceMapper(){
       return new ResourceMapper();
    }
}