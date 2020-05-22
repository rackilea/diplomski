@Configuration
public class BeanConfig {

    @Bean
    @Scope(value="prototype")
    public Item item(){
        return new Item();
    }


    @Bean
    public ItemManager itemManager(){
        return new ItemManager() {

            @Override
            public Item createItem() {
                return item();
            }
        };
    }
}