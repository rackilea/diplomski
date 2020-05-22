public class SampleTasklet implements Tasklet {

private UserService userService;

    public SampleTasklet (UserService userService){
        this.userService=userService;
    }