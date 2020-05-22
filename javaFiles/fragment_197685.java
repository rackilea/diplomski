public class YourListener implements ApplicationListener<ContextRefreshedEvent>, Ordered {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) { }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    } 
}