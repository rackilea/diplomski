synchorized(messages){
   if(messages.size()<=0) messages.wait(); // when you receive a new message you have to notify
}
synchorized(messages){
   Message msg = messages.get(0);
   messages.remove(0);
   showmessage_to_ouput(msg); // something like this.

   String s = read from input // to reply to this message.
   Reply(....)// here you can check if this message is group message--> reply to all,..etc
}