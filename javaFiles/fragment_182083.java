@Controller
class MyController {
   @RequestMapping
   public kickOffHandlerMethod() {
      myServiceClass.myServiceMethod();
      }
   }
   @RequestMapping
   public dependentHandlerMethod() {
      if(myServiceClass.getIsDone()) {
         ...do something...
      }
   }
}