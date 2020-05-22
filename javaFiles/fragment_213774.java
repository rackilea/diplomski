@Configuration
@ComponentScan(basePackages = {
        <packages of JPAServiceFactory and other requires beans>
})
@ServletComponentScan(basePackages = <the web servlets package>)
public class ODataConfig {

}