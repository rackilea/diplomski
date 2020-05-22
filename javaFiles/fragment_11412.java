/** Sends a new message. */
 public void send(String recipient, String subject, String content_type, String content)                                                                                                             {  
 //    Receiver.engine(Receiver.mContext).ua.
  NameAddress to_url = new NameAddress("Win@192.168.1.37");//recipient);
  NameAddress from_url=new NameAddress(user_profile.from_url);
  Log.e("IMHANDLER","$$$$$$$$$$$$$ to_url"+to_url+" from_url"+from_url+" recipient"+recipient);
  Message req=MessageFactory.createMessageRequest(sip_provider,to_url,from_url,subject,content_type,content);
  TransactionClient t=new TransactionClient(sip_provider,req,this);
  t.request();
 }