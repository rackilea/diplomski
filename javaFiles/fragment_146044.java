import java.io.PrintWriter;
import java.io.StringWriter;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageReceiver implements MessageListener{

     Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("message:"+textMessage.getText());
            CustomClass activeMq =new ObjectMapper().readValue(textMessage.getText(),CustomClass.class);
            LOG.info("Application : Active Mq : {}",activeMq);  

        } catch (Exception e) {     
            e.printStackTrace();            
        }

    }
}