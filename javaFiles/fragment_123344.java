@Stateless
@LocalBean
public class RulesBean {
    private static final String CUSTOMERS = "/customers"

    @Resource
    SessionContext ctx;

    public boolean isAllowed(String url) throws PermissionException {
        switch(url){
            case CUSTOMERS: return self().canViewAllCustomers(); 
            default: return true;
        }
    }

    private RulesBean self() {
        return ctx.getBusinessObject(RulesBean.class);
    }

    /*This should trigger PermitInterceptor before entering method and 
    should throw my custom PermissionException if permission fails*/
    @Permit(actions={"ViewCustomers"}) 
    public boolean canViewAllCustomers(){
        return true;
    }
}