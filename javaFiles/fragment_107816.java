package test.jms.hornetq;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.core.client.*;
import org.hornetq.api.core.management.ManagementHelper;
import org.hornetq.core.remoting.impl.invm.InVMConnectorFactory;

public class HornetqService {

    public void testPauseResumeQueue() {
        // this class needs to run in the same jvm as the wildfly server (i.e. not a remote jvm)
        try {
            ServerLocator locator = HornetQClient.createServerLocatorWithoutHA(new TransportConfiguration(
                    InVMConnectorFactory.class.getName()));

            ClientSession session = locator.createSessionFactory().createSession();

            session.start();

            ClientRequestor requester = new ClientRequestor(session, "jms.queue.hornetq.management");

            String queueName = "testQueue"; // use your queue name here

            // get queue message count
            ClientMessage message = session.createMessage(false);
            ManagementHelper.putAttribute(message, queueName, "messageCount");

            ClientMessage reply = requester.request(message);
            int count = (Integer) ManagementHelper.getResult(reply);
            System.out.println("There are " + count + " messages in exampleQueue");

            // pause the queue
            message = session.createMessage(false);
            ManagementHelper.putOperationInvocation(message, queueName, "pause");

            requester.request(message);

            // get queue paused
            message = session.createMessage(false);
            ManagementHelper.putAttribute(message, queueName, "paused");
            reply = requester.request(message);
            Object result =  ManagementHelper.getResult(reply);
            System.out.println("result: " + result.getClass().getName() + " : " + result.toString());

            // resume queue
            message = session.createMessage(false);
            ManagementHelper.putOperationInvocation(message, queueName, "resume");
            requester.request(message);

            // get queue paused
            message = session.createMessage(false);
            ManagementHelper.putAttribute(message, queueName, "paused");
            reply = requester.request(message);
            Object result2 =  ManagementHelper.getResult(reply);
            System.out.println("result2: " + result2.getClass().getName() + " : " + result2.toString());

            requester.close();

            session.close();
        }catch (Exception e){
            System.out.println("Error pausing queue" + e.getMessage());
        }
    }
}