@SpringBootApplication
@ComponentScan({
    "fullPackage.controller",
    "fullPackage.service"
    })
@EnableJpaRepositories(basePackages = {
    "fullPackage.repository"     
   })
@EntityScan(basePackages= {
    "fullPackage.entity"
    })
public class SchedulerApplication { 
}