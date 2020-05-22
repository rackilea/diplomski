@Stateless
@LocalBinding(jndiBinding = TaskServiceBean.LOOKUP_STRING)
@SecurityDomain(value = Security.DOMAIN)
@DeclareRoles({ Roles.ADMIN, Roles.CLERK, Roles.READ_ONLY })

//By default, allow no one access, we'll enable access at the method level
@RolesAllowed({})
public class TaskServiceBean implements TaskServiceBeanLocal
{
    public static final String LOOKUP_STRING = "TaskServiceBean/local";

    @RolesAllowed({ Roles.ADMIN, Roles.CLERK })
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Task save(Task task)
    {
        ...
    }
}