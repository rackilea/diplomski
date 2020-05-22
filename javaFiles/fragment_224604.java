public class MyWriter{
   @Autowired
   @Qualifier("ftpChannel")
   private MessageChannel messageChannel;
   public void write(YourItem pack) throws IOException {
   //create your file and from your Item 
   File file = new File("the_created_file");
   // Sending the file via Spring Integration Ftp Channel
   Message<File> message = MessageBuilder.withPayload(file).build();
   messageChannel.send(message);
   }