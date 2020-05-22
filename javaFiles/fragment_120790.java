public enum TaskName {
     LOGIN {
         @Override
         public void doIt(TaskController taskController) {
              taskController.getUserDao().create(/*something*/);
              //...
         }
     },
     REGISTER {
         @Override
         public void doIt(TaskController taskController) {
              //Implementation
         }
     },
     MESSAGE {
         @Override
         public void doIt(TaskController taskController) {
              taskController.getMessageDao().create(/*something*/);
              //...
         }
     };

     private TaskName() {
     }

     public abstract void doIt(TaskController taskController);

     public static TaskName getByTaskName(String taskName) {
         for(TaskName taskEnum : TaskName.values()) {
             if(taskEnum.name().equalsIgnoreCase(taskName)) {
                 return taskEnum;
             }
         }
         throw new IllegalArgumentException("The Task Name [" + taskName + "] is not a valid task name!");
     }
}

public class TaskController {


    private UserDao userDaoJpaImpl;
    private FriendDao friendDaoJpaImpl;
    private GroupDao groupDaoJpaImpl;
    private MessageDao messageDaoJpaImpl;

    public TaskController() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        userDaoJpaImpl = new UserDaoJpaImpl(emfactory);
        friendDaoJpaImpl = new FriendDaoJpaImpl(emfactory);
        groupDaoJpaImpl = new GroupDaoJpaImpl(emfactory);
        messageDaoJpaImpl = new MessageDaoJpaImpl(emfactory);
    }

    public void doIt(String taskName) {
        TaskName.getByTaskName(taskName).doIt(this);
    }
}