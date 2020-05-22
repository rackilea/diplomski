public void dataReceived(TelnetDataReceivedEvent event) {

try{
        // print data received from telnet server to console

String s=event.getData();

String final_data=s.substring(s.length()-14);
         System.out.print(final_data.Trim());
}

catch(Exception e)
{
System.out.println(e.message())

}
        }