@Override
public void configure() throws Exception {


from("seda:rest_upload")
 .multicast()
 .to("direct::sendMainFile")
 .to("direct:sendAnotherFile") // You could also use seda:
 .end();



from("direct:sendMainFile")
.process(new Processor() {
 @Override
      public void process(Exchange exchange) throws Exception {
        String filepath = <calculate filepath>;
        String completeFilePath = systemSettingsService.getSystemSettings().getSftpAttachmentsPushFailedPath() + filepath
        exchange.getIn().setHeader("destFilePath", completeFilePath);
         exchange.getIn().setHeader("CamelFileName", fileNameforMainFile);
    }
 }.toD(sftpRoute()) // It is toD not to


from("direct:sendAnotherfile")
.process(new Processor() {
          @Override
          public void process(Exchange exchange) throws Exception {
            // Here you have the same body which was sent from rest_upload
            // extract the info from exchange.getIn().getBody() 
            // Read the file and set it as exchange body

            String fileContent = <Your logic to read file>
            exchange.getIn().setBody(fileContent);
            exchange.getIn().setHeader("CamelFileName", fileNameforYourAdditionalFile)

            String completeFilePath = systemSettingsService.getSystemSettings().getSftpAttachmentsPushFailedPath() + filepath
            exchange.getIn().setHeader("destFilePath", completeFilePath);
          }
        })
 .toD(sftpRoute());  // It is toD not to

}    

private String sftpRoute() {

 return String.format(SFTP_BASE_URL,systemSettingsService.getSystemSettings().getSftpUserName(),               
  systemSettingsService.getSystemSettings().getSftpHost(),
  systemSettingsService.getSystemSettings().getSftpPort(),
                "${header.destFilePath}",                  
  systemSettingsService.getSystemSettings().getSftpPassword())
  }
 }