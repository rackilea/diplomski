@Local
public interface TaskServiceBeanLocal extends ObjectRepository<Task>
{
    public void test();
}

//and implement the test() method, having the same permission as the save() method.
public class TaskServiceBean implements TaskServiceBeanLocal
{
    @RolesAllowed({ Roles.ADMIN, Roles.CLERK })
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Task save(Task task)
    {
        ...
    }

    @RolesAllowed({ Roles.ADMIN, Roles.CLERK })
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void test()
    {
        System.out.println("hello");
    }
}