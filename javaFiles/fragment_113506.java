package com.camel.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.cxf.DefaultCxfBinding;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelViralTest {
    static CamelContext context;

    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        ProducerTemplate template = context.createProducerTemplate(0);

        context.start();
        String url = "cxf://http://localhost:8081/buzzor-service/services/ApplicationService?"
                + "wsdlURL=http://localhost:8081/buzzor-service/services/ApplicationService?wsdl&"
                + "serviceName={http://service.application.buzzor.atpl.com}ApplicationService&"
                + "portName={http://service.application.buzzor.atpl.com}ApplicationServiceHttpPort"
        +"&dataFormat=MESSAGE";
        Exchange e=sendSimpleMessage1(template,url);
        System.out.println(e.getOut().getBody());
        Thread.sleep(10000);
        context.stop();
    }

    private static Exchange sendSimpleMessage1(ProducerTemplate template,
            String endpointUri) {

        final List<String> params = new ArrayList<String>();
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put(CxfConstants.OPERATION_NAME, "getApplication");
        headers.put("requestObject", new DefaultCxfBinding());
        params.add("hello world");

        Exchange exchange = template.request(endpointUri, new Processor() {
            public void process(final Exchange exchange) throws Exception {
                SOAPMessage soapMessage=createSOAPRequest();
                exchange.getIn()
                        .setBody(  soapMessage.getSOAPBody());
            }
        });
        return exchange;

    }

    private static SOAPMessage createSOAPRequest() throws Exception {
         MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            String serverURI = "http://ws.cdyne.com/";

            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("example", serverURI);

            javax.xml.soap.SOAPBody soapBody = envelope.getBody();
            SOAPElement soapBodyElem = soapBody.addChildElement("getApplication", "example");
           /* SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("data", "example");
            soapBodyElem1.addTextNode("mutantninja@gmail.com");*/
            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", serverURI  + "getApplication");

            soapMessage.saveChanges();

            /* Print the request message */
            System.out.print("Request SOAP Message = ");
            soapMessage.writeTo(System.out);
            System.out.println();

            return soapMessage;
    }
}