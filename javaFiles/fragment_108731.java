@Controller
public class YourController() {

    @RequestMapping(value = "/restapi/{entityType}")
    public String postEntity(HttpServletRequest request, @PathVariable(value = "entityType") String entityType) {
        // If enetity name will be packegae + class name
        Object beanInstance = Class.forName(entityName);
        ServletRequestDataBinder binder = new ServletRequestDataBinder(beanInstance);
        binder.bind(request);

        // Here by type of entity you can get DAO and persist
    }
}