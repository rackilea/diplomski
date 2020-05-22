// newMessages - it is array of messages from the mail inbox
// create copy of the message using MimeMessage constructor
MimeMessage message = new MimeMessage(newMessages[0]); // without it, the content was as in my first post
// get content from the mssage
Object messageContent = message.getContent();
// output it as a string
System.out.println(messageContent.toString());