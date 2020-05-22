import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;
import org.asteriskjava.fastagi.reply.AgiReply;

public class HelloAgiScript extends BaseAgiScript {

    @Override
    public void service(AgiRequest arg0, AgiChannel arg1) throws AgiException {
        String choice;
        // Answer the channel
        answer();
        //say hello
        streamFile("silence/1");
        streamFile("welcome");
        //Ask for an input and give feedback
        System.out.println("test");
        exec("Background","press-1&or&press-2&silence/3"); //Executes Background application
        AgiReply agiReply = getLastReply(); //Get the reply in the form of an AgiReply object
        choice=agiReply.getResult(); //Extract the actual reply
        choice=Character.toString((char) Integer.parseInt(choice)); // convert from ascii to actual digit
        System.out.println("choice: "+choice);
        streamFile("silence/1");
        sayDigits(choice);
        streamFile("silence/1");
        //and hangup
        hangup();   
    }
}