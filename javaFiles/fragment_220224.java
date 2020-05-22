class MyBeanCreator implements BeanFactoryAware {

  private AutowireCapableBeanFactory beanFactory; //you need to add setter as well

  def foobar() {
    //your existing code....
    final GroovyObject groovyObject = (GroovyObject) this.groovyClass.newInstance();

    //Wire with Spring 
    beanFactory.autowireBean(groovyObject);

    //rest of your existing code...
  }

}