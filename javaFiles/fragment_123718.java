import org.codehaus.groovy.grails.commons.ApplicationHolder

public class SomeClass  {
   SomeService someService;
   public SomeClass()  {
       someService = (SomeService) ApplicationHolder.getApplication().getMainContext().getBean("someService");
   }
}