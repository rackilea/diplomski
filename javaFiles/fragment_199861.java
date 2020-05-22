package customizer;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.oxm.mappings.XMLDirectMapping;

public class CustomQuoteRequestCustomizer implements DescriptorCustomizer {

    public void customize(ClassDescriptor descriptor) throws Exception {
        XMLDirectMapping  currencyPairCodeLegMapping = new XMLDirectMapping();
        currencyPairCodeLegMapping.setAttributeName("currencyPairCode");
        currencyPairCodeLegMapping.setXPath("QuotReq/QuoteReq/Leg/Leg/@Sym");
        currencyPairCodeLegMapping.setIsWriteOnly(true);
        descriptor.addMapping(currencyPairCodeLegMapping);

    }

}