package nl.hari.local.cust;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

import nl.hari.local.jaxb.Address;
import nl.hari.local.jaxb.ObjectFactory;

public class Camel_JAXB_UnMarshal {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        try {

            ClassLoader cl = ObjectFactory.class.getClassLoader();
            JAXBContext jc = JAXBContext.newInstance(Address.class.getPackage().getName(), cl);
            final JaxbDataFormat jaxb = new JaxbDataFormat(jc);
            jaxb.setPartClass(Address.class.getName());

            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:resources"). //This can be changed as per ur requirement.
                    convertBodyTo(String.class)
                    .unmarshal(jaxb)
                    .process(new Processor() {

                        public void process(Exchange exchange) throws Exception {
                            Address add = (Address) exchange.getIn().getBody();
                            System.out.println("city is" + add.getCity());

                        }

                    });
                }
            });
            context.start();
            Thread.sleep(2000);
        } finally {
            context.stop();
        }
    }
}