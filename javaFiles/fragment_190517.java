@Stateless
public class MyBean(){

    @Resource
    private SessionContext ctx;

    public void doSomething() {
        try {
            //code that sends a mail
        } catch (Exception e) {
            ctx.setRollbackOnly(); //the transaction will not commit
           //log exception

        }
    }
 }