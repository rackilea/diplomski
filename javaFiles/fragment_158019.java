@Named
@ApplicationScoped
class PermissionManager { 
  ...
  public void checkRoles(ComponentSystemEvent event) {

       String acl = "" + event.getComponent().getAttributes().get("roles");
       //Check user role
       ...
       //Redirect if required
       try {

        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context
                .getApplication().getNavigationHandler();
        handler.performNavigation("access-denied");
    } catch (Exception e) {
        ...
    }

   }

}