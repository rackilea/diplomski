@Autowired
private AutowireCapableBeanFactory beanFactory;

public void doDeserialization() {

   Container[] containers = // get them via jackson
   for (Container container : containers) {
      beanFactory.autowireBean(container);
      // container will now have its dependencies autowired.
   }
}