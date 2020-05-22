public class MyApp  {
    private Session currentSession;
    public MyApp() {
        currentSession = new Session();
    }
    public void login() {
        //...
        if ( studentID != null ) {
            if ( password.equals(student.password) ) {
                currentSession.setCurrentUserId(studentID);
                //...
            }
        }
        //...
    }
    public void someOtherMethod() {
        System.out.println(currentSession.getCurrentUserId());
    }
}