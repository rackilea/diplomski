final Messenger messenger = new Messenger(handler); 
. 
.
msg.replyTo = messenger;  // set the handler of the reply activity.
msg.setData(mBundle);     // if any additional data available put to a bundle
destinationClass.mHandler.sendMessage(msg);



// in destination class

Messenger msger = msg.replyTo;  // get the message sender's details.

Message msg2 = Message.obtain();
msger.send(msg2);                // send the reply message again to the sender