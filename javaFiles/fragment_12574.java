package com.xxx.xxx.xxx.xxx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class CustomMessageInterceptor extends AbstractPhaseInterceptor<Message> {

    public CustomMessageInterceptor() {
        super(Phase.PRE_STREAM);
        addBefore(SoapPreProtocolOutInterceptor.class.getName());
    }

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public void handleMessage(
            Message message) {

        OutputStream os = message.getContent(OutputStream.class);

        CachedStream cs = new CachedStream();
        message.setContent(OutputStream.class, cs);

        message.getInterceptorChain().doIntercept(message);

        try {
            cs.flush();
            IOUtils.closeQuietly(cs);
            CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);

            String currentEnvelopeMessage = IOUtils.toString(csnew.getInputStream(), "UTF-8");
            csnew.flush();
            IOUtils.closeQuietly(csnew);

            if (log.isDebugEnabled()) {
                log.debug("Outbound message: " + currentEnvelopeMessage);
            }

            String res = changeOutboundMessage(currentEnvelopeMessage);
            if (res != null) {
                if (log.isDebugEnabled()) {
                    log.debug("Outbound message has been changed: " + res);
                }
            }
            res = res != null ? res : currentEnvelopeMessage;

            InputStream replaceInStream = IOUtils.toInputStream(res, "UTF-8");

            IOUtils.copy(replaceInStream, os);
            replaceInStream.close();
            IOUtils.closeQuietly(replaceInStream);

            os.flush();
            message.setContent(OutputStream.class, os);
            IOUtils.closeQuietly(os);

        }
        catch (IOException ioe) {
            log.error("Unable to perform change.", ioe);
            throw new RuntimeException(ioe);
        }
    }

    protected String changeOutboundMessage(
            String currentEnvelope) {
        currentEnvelope = currentEnvelope.replace("<ClruInsert xmlns=\"\" xmlns:ns22=\"http://services/businessdomain/distributionmanagement/maintenance/maintenancerequestsresponses\">", "<ClruInsert>");
        currentEnvelope = currentEnvelope.replace("<BusinessTypeCd xmlns=\"\" xmlns:ns22=\"http://services/businessdomain/distributionmanagement/maintenance/maintenancerequestsresponses\"", "<BusinessTypeCd");

        return currentEnvelope;     
    }

    private class CachedStream extends CachedOutputStream {
        public CachedStream() {
            super();
        }
    }
}