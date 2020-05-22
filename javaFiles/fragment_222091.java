import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.jms.JmsDestination;
import com.ibm.msg.client.wmq.WMQConstants;
import com.ibm.msg.client.jms.JmsConstants;
import com.ibm.mq.jms.MQDestination;

public class AccountingTokenDemo {

    public static void main(String[]args) {
        // TODO Auto-generated method stub
        AccountingTokenDemo demo = new AccountingTokenDemo();
        demo.putMessageWithAccountingToken();
    }
       public void putMessageWithAccountingToken() {
            JmsConnectionFactory cf = null;
            Connection connection = null;
            Session session = null;
            Destination reqQ = null;
            MessageProducer producer = null;

            try {               
              // Create a connection factory
              JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
              cf = ff.createConnectionFactory();

              // Set the properties
              cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_BINDINGS);
              cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "QM2");

              // Create JMS objects
              connection = cf.createConnection();
              session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

              // Create a 32 byte accounting toke
              byte [] accountingToken = new byte[32];
              byte b = 'a';
              for(int i=0; i < 32;i++)
                accountingToken[i] = b++;

              // Create destination to send requests
              reqQ = session.createQueue("queue:///REQUESTQ");
              ((MQDestination) reqQ).setTargetClient(WMQConstants.WMQ_CLIENT_NONJMS_MQ);              
              ((JmsDestination) reqQ).setBooleanProperty(WMQConstants.WMQ_MQMD_READ_ENABLED, true);
              ((JmsDestination) reqQ).setBooleanProperty(WMQConstants.WMQ_MQMD_WRITE_ENABLED, true);    
              ((MQDestination) reqQ).setMQMDMessageContext(WMQConstants.WMQ_MDCTX_SET_IDENTITY_CONTEXT);

              // Create producer
              producer = session.createProducer(reqQ);

              // Create a request message
              Message requestMessage = session.createTextMessage("Setting Accounting token on message");
              requestMessage.setObjectProperty(JmsConstants.JMS_IBM_MQMD_ACCOUNTINGTOKEN, accountingToken);
              // Send it off
              producer.send(requestMessage);

            }catch(Exception ex){
                System.out.println(ex);
            }
       }       
}