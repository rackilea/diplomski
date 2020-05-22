ReceivedChat(String message, String from,Context context)
{
this.message = message;
this.from = from;
this.context=context;  //<< initialize Context here 
Intent i = new Intent(context,XmppChatActivity.class);
 //....your code here
context.startActivity(i);

}