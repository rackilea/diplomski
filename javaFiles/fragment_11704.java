package learning.jms;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Message;
import javax.jms.Queue;

@Named(value="senderBean")
@SessionScoped
public class SenderBean implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Resource(mappedName="queues/myQueue")
    private transient Queue myQueue;

    @Inject
    @JMSConnectionFactory("java:/DefaultJMSConnectionFactory")
    private transient JMSContext context;

    private String messageText;

    private int nextType;

    public SenderBean() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void init(){
        nextType=2;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void sendJMSMessageToMyQueue() {
        try {
           String text = "Message from producer: " + messageText;
           Message m1 = context.createTextMessage(text);
           m1.setIntProperty("type", nextType);

           nextType = (nextType++%3)+1;

           context.createProducer().send(myQueue, m1);

           FacesMessage facesMessage =
                   new FacesMessage("Sent message: " + text);
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
       } catch (JMSRuntimeException | JMSException t) {
            System.out.println(t.toString());
       }
   }
}