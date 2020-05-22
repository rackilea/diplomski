@Local
public interface TaskServiceBeanLocal extends ObjectRepository<Task>
{
    public Task save(Task object);
    public void test();
}