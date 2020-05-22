@RestController
public class myHomeController{
   ...
   @RequestMapping("/getValues")
   public someDomainClass getMyValues(){
      ...
      //someDomainClass is just a reg. pojo to store your values.
      someDominClass class1 = new someDomainClass(value1, value2, value3
       , value4);
      return class1;
   }
}