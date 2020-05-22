static { 
     // DataHandler.writeTo() may search for DCH. So adding some default ones.
     try {
         CommandMap map = CommandMap.getDefaultCommandMap();
         if (map instanceof MailcapCommandMap) {
             MailcapCommandMap mailMap = (MailcapCommandMap) map;
             String hndlrStr = ";;x-java-content-handler=";
             mailMap.addMailcap(
                 "text/xml" + hndlrStr + XmlDataContentHandler.class.getName());
             mailMap.addMailcap(
                 "application/xml" + hndlrStr + XmlDataContentHandler.class.getName());
             mailMap.addMailcap(
                 "image/*" + hndlrStr + ImageDataContentHandler.class.getName());
             mailMap.addMailcap(
                 "text/plain" + hndlrStr + StringDataContentHandler.class.getName());
         }
     } catch (Throwable t) {
         // ignore the exception.
     }
 }