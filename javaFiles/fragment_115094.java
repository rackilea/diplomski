package org.springframework.integration.ftp.config;

public class FtpNamespaceHandler extends org.springframework.integration.config.xml.AbstractIntegrationNamespaceHandler {

    @Override
    public void init() {
        System.out.println("Initializing FTP updating file synchronizer.");
        // one updated line below, rest copied from original FtpNamespaceHandler
        registerBeanDefinitionParser("inbound-channel-adapter", new MyFtpInboundChannelAdapterParser());
        registerBeanDefinitionParser("inbound-streaming-channel-adapter",
                new FtpStreamingInboundChannelAdapterParser());
        registerBeanDefinitionParser("outbound-channel-adapter", new FtpOutboundChannelAdapterParser());
        registerBeanDefinitionParser("outbound-gateway", new FtpOutboundGatewayParser());
    }

}

package org.springframework.integration.ftp.config;

import org.springframework.integration.file.remote.synchronizer.InboundFileSynchronizer;
import org.springframework.integration.ftp.config.FtpInboundChannelAdapterParser;

public class MyFtpInboundChannelAdapterParser extends FtpInboundChannelAdapterParser {

    @Override
    protected Class<? extends InboundFileSynchronizer> getInboundFileSynchronizerClass() {
        System.out.println("Returning updating file synchronizer.");
        return FtpUpdatingFileSynchronizer.class;
    }

}