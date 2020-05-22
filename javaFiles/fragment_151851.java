@WebService(serviceName = "NotificationServices")
@Named(value="notificator")
public class NotificationServices {

    private final PushContext pushContext = PushContextFactory.getDefault().getPushContext();

    /**
     * Push a notification to a user
     */
    @WebMethod(operationName = "pushNotification")
    public void pushNotification(@WebParam(name = "username") String username,
                                 @WebParam(name = "message") String message) {
        pushContext.push("/notification/" + username, message);
    }
}