public class ClientScope implements Scope {
   @Autowired
   BeanFactory beanFactory;

   Object get(String name, ObjectFactory<?> objectFactory){
       //we do not use the objectFactory here, instead the beanFactory           
       //you somehow have to know which client is the current
       //from the config, current request, session,  or ThreadLocal..
       String client=findCurrentClient(..);
       //client now is something like 'Client1'

      //check if your cache (HashMap) contains an instance with
      //BeanName = name for the client, if true, return that
       ..  
      //if not, create a new instance of the bean with the given name 
      //for the current client. Easiest way using a naming convention 
        String clientBeanName=client+'.'+name;
        Object clientBean=BeanFactory.getBean(clientBeanName);
      //put in cache ...
        return clientBean;  
   };
}