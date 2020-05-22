public class LogUserAction implements Action<LogUserContext> {

     @Override
     public void resolve(LogUserContext context) {
         User user = context.get("theUser");
         // log the user in
     }
}