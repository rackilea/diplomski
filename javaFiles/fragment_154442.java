@Configuration
public class MyConfiguration{

@Bean
public IndexUpdater getIndexUpdater(){
     return new IndexDirectUpdater();
}

@Bean 
public SearchIndexImpl getSearchIndexFoo(){
     return new SearchIndexImpl(getIndexUpdater());
}