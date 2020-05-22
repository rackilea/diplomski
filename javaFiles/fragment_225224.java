AxisCallback callBack = new AxisCallback() {

@Override
public void onMessage(MessageContext msgContext) {
    System.out.println(msgContext.getEnvelope().getBody().getFirstElement());
    //this method get called when you received the results from the backend
}
...
}