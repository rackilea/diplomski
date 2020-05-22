/**
 * QueueBrowserGss.java
 * 
 * Created on Sep 24, 2012, 3:52:28 PM
 *
 * To the extent possible under law, Red Hat, Inc. has dedicated all copyright to this 
 * software to the public domain worldwide, pursuant to the CC0 Public Domain Dedication. This 
 * software is distributed without any warranty.  
 *
 * See <http://creativecommons.org/publicdomain/zero/1.0/>.
 *
 */
package com.redhat.gss.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author grovedc
 * 
 */
public class QueueBrowserGss {
    private static final Log logger = LogFactory.getLog(QueueBrowserGss.class);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        QueueConnection queueConnection = null;
        Queue queue = null;
        QueueConnectionFactory queueConnFactory = null;
        QueueBrowser queueBrowser = null;
        QueueSession queueSession = null;

        List<Object> messages = new ArrayList<Object>(7000);

        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        // properties.put(Context.PROVIDER_URL, "jnp://" + server + ":" + port);
        properties.put("Context.PROVIDER_URL", "jnp://10.0.0.150:1100");

        try {
            InitialContext ctx = new InitialContext(properties);
            queue = (Queue) ctx.lookup("queue/D");
            queueConnFactory = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");

            queueConnection = queueConnFactory.createQueueConnection();
            queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            queueBrowser = queueSession.createBrowser(queue);
            queueConnection.start();

            for (Enumeration<Object> e = queueBrowser.getEnumeration(); e.hasMoreElements();) {
                  messages.add(e.nextElement());
            }

            logger.info("Messages are retrieved from queue. Process completed on: " + new Date());
            logger.info("Number of Messages present: " + messages.size());

        } catch (Exception ex) {
            logger.error(String.format("Exception Occured : %s", ex.getMessage()),  ex);
        } finally {
            try {
                if (queueConnection != null)
                    queueConnection.stop();
            } catch (JMSException e) {
                logger.error(e);
            }
        }
    }
}