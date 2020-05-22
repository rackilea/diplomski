if((recipientsBcc != null) && (recipientsBcc.length > 0))
{          
    addressBcc = new InternetAddress[recipientsBcc.length];
}
MimeMessage message = new MimeMessage(session);  
message.setFrom(new InternetAddress(Receipt_From));
if(addressBcc != null)
{
    for (int i = 0; i < recipientsBcc.length; i++) 
    {
        addressBcc[i] = new InternetAddress(recipientsBcc[i]);
        //This will send indiviaual emails.
        message.setRecipients(Message.RecipientType.TO, addressBcc); 
        Transport.send(message);
    }
}