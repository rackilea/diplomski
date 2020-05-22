Bridge.getInstance().registerMessageHandler("Reply", messageHandlerInstance );

public void handleMessage( IMessage message )

{

System.out.println( message.getData() );

}