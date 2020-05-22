public class MyBean implements InitializingBean {


   @PostConstruct
   void aMethodToExecuteAfterTheBeanInit() {
       // ....
   }
}