//Startpoint
public class Main
{
    public static void main(String[] args)
    {
         new EspduReceiverGUI();    //start gui somehow
    }
}

//GUI
public class EspduReceiverGUI
{
    //only exists once
    private static EspduData handler;

    //Get your Data and do something with it
    public EspduReceiverGUI()
    {
         handler = new EspduReceiver();
         PDU data = handler.getPDUData();

         doSomething(data);
    }
}

//Receiver
public class EspduReceiver implements EspduData
{
    //Variablen, Sockets etc.

    public PDU getPDUData()
    {
        //receive data and return
        //return pdu;
    }

}