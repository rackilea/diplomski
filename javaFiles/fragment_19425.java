import com.ctc.wstx.osgi.InputFactoryProviderImpl;
import com.ctc.wstx.osgi.OutputFactoryProviderImpl;
import org.codehaus.stax2.XMLEventReader2;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.XMLOutputFactory2;

InputFactoryProviderImpl iprovider = new InputFactoryProviderImpl();
OutputFactoryProviderImpl oprovider = new OutputFactoryProviderImpl();

XMLInputFactory2 ifactory = iprovider.createInputFactory();
XMLOutputFactory2 ofactory = oprovider.createOutputFactory();

XMLEventReader2 in = (XMLEventReader2) ifactory.createXMLEventReader(
        new BufferedInputStream(
                new FileInputStream(filePath)));

XMLEventWriter out = ofactory.createXMLEventWriter(result);