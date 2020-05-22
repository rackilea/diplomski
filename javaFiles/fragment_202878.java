public class AuthenticationInterceptor implements Interceptor {

public void destroy() {
}

public void init() {
}

public String intercept(ActionInvocation actionInvocation) throws Exception {
    Map session = actionInvocation.getInvocationContext().getSession();
    User user = (User) session.get(Struts2MyConstants.USER);

    if (user == null) {
        return Action.LOGIN; //login required result
    }               
    else {              
        Action action = (Action)actionInvocation.getAction();

        if (action instanceof UserAware) {
            User freshUser = myService.getUser(user.getId());
            ((UserAware)action).setUser(freshUser);
        }

        System.out.println("Logged in: interceptor");
        return actionInvocation.invoke();
    }
}