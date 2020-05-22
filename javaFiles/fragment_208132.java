@Configuration
public class Configurer {

    @Bean(initMethod="onStart", destroyMethod="onStop")
    StartAndStop startAndStop() {
        return new StartAndStop();
    }
    ... other beans configuration ...
}