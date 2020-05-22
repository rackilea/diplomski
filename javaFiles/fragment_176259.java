<%@taglib uri="/spring.tld" prefix="spring"%>
<spring:bind path="MyPojo[${statusInd.index}].selected">
input type="hidden"
   name='<c:out value="${status.expression}"/>'
   id='<c:out value="${status.expression}" />'
  value='<c:out value="${status.value}" />' />                                  
</spring:bind>      

@SessionAttributes("testform")
public class testController{
    public ModelAndView testmethod(@ModelAttribute("testform")  MyPojo[] testMyPojo,HttpServletRequest request){
     /*
      Access form variable using ModelMap.
    */
    }
}