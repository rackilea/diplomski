package org.nkl.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.nkl.model.Message;
import org.nkl.model.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class MessageHandlerBean implements MessageHandler {

    @PersistenceContext
    private EntityManager em;

    Logger logger = LoggerFactory.getLogger(MessageHandlerBean.class);

    public void saveMessages() {
        logger.info("In saveMessages");
        em.persist(new Message("Hello World"));
    }

    @SuppressWarnings("unchecked")
    public void showMessages() {
        logger.info("In showMessages");
        List messages = em.createQuery(
                "select m from Message m order by m.text asc").getResultList();
        for (Object o : messages) {
            logger.info(((Message) o).getText());
        }
    }
}