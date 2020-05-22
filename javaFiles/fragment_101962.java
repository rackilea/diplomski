@Override
public void handleMessage(Message message) throws Fault {

    List mcl = message.getContent(List.class);
    if (mcl != null) {
        for (Object o : mcl) {
            if (o instanceof BaseRequest) {
                BaseRequest baseRequest = (BaseRequest) o;
            }
        }
    }

}