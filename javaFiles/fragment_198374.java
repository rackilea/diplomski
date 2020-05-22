public class ServiceA implements ExecutesService<Response1,Request1> {

    List<Class> supportedListOfServices = new ArrayList<>();
    //load list of classnames supported by ServiceA during startup from properties

    public Response1 executeService(Request1 request1, Service service) {
        if(!list.contains(Service.class)) {
           throw new UnsupportedOperationException("This method should 
                      not be called for this class");
        } else {
            return service.execute(request1);
        }
    }
}