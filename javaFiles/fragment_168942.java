public void process(Exchange ex) throws Exception {

    javax.mail.Message mailMessage = ex.getIn(org.apache.camel.component.mail.MailMessage.class).getMessage();

    File file = new File( "backupDirectory", "DesiredFileName.eml");
    DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));       
    mailMessage.writeTo(os);
    os.close();
}