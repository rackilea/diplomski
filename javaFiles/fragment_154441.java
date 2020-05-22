@Configuration
public class MyConfiguration{

@Bean
public IndexUpdater getIndexUpdater(){
     return new IndexDirectUpdater();
}