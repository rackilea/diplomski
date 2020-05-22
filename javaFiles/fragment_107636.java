public void shortenMessage(String inMessage) {
     for (Entry<String, String> entry:this.abbreviations.entrySet()) 
         inMessage = inMessage.replaceAll(entry.getKey(), entry.getValue());

     System.out.println(inMessage);
}