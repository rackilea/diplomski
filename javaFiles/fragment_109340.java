import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

public class MessageServlet extends HttpServlet {

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putString(String myString) throws JMSException {
        MessageProducer producer = (MessageProducer) getServletContext()
                .getAttribute(MyContextListener.ACTIVE_MQ_PRODUCER);

        Session session = (Session) getServletContext().getAttribute(
                MyContextListener.ACTIVE_MQ_SESSION);
        TextMessage txtmessage = session.createTextMessage();
        if (txtmessage != null && producer != null) {
            txtmessage.clearBody();
            txtmessage.setText(myString);
            producer.send(txtmessage);
        }
    }
}