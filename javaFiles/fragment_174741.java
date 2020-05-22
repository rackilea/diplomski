public class SomeBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() {  // this is the callback method
                                        // for the bean creation phase of the 
                                        // spring bean lifecycle
        // do something after the properties are set during bean creation
    }
}