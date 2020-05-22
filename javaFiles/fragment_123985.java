@Bean
public Job myJob(){
    return jobs.get("myJob")           
        .listener(new DoSomethingAroundJob())          
        .build();
}