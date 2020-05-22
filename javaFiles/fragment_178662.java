package org.nkl;

import java.io.File;

import javax.naming.InitialContext;

import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import org.jboss.ejb3.embedded.EJB3StandaloneDeployer;
import org.junit.Test;
import org.nkl.model.MessageHandler;

public class BasicTest {

    @Test
    public void testEjb() throws Exception {
        EJB3StandaloneBootstrap.boot(null);
        EJB3StandaloneBootstrap.deployXmlResource("META-INF/beans.xml");
        EJB3StandaloneDeployer deployer = EJB3StandaloneBootstrap
                .createDeployer();

        deployer.getArchives().add(new File("target/classes").toURI().toURL());

        deployer.create();
        deployer.start();
        InitialContext context = new InitialContext();
        MessageHandler messageHandler = (MessageHandler) context
                .lookup("MessageHandlerBean/local");
        messageHandler.saveMessages();
        messageHandler.showMessages();
        EJB3StandaloneBootstrap.shutdown();
    }
}