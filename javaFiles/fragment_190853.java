import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FatalErrorTest
{

    @Test
    public void as_given() throws SAXException, IOException, ParserConfigurationException
    {
        String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<?xfa generator=\"ff99v250_01\" APIVersion=\"1.4.3139.0\"?>\r\n<jfxpf:XPF xmlns:jfxpf=\"http://www.xfa.com/schema/xml-package\">\r\n   <jfxpf:Package>\r\n      <jfxpf:Resource Location=\"GenReq\">\r\n         <jfxpf:Link ContentType=\"application/x-jetform-cft\" />\r\n      </jfxpf:Resource>\r\n      <jfxpf:Resource Location=\"default.xml\">\r\n         <jfxpf:Content ContentType=\"text/xml\" Location=\"default.xml\">\r\n            <xfa:Data xmlns:xfa=\"http://www.xfa.org/schema/xfa-data/1.0/\">\r\n               <xfa:DataGroup>\r\n                  <data xmlns:xfe=\"http://www.xfa.org/schema/xfa-events/1.0\" xfe:script=\"$config.proto.common.template.uri='GenReq'\" xfe:event=\"$config:load\">\r\n                     <?jetform ^Dat ^page 1?>\r\n                     <FR_NAME>Administrator</FR_NAME>\r\n                     <JFWF_DELEGATE />\r\n                     <ADHOC_DLN_ACTOR />\r\n                     <ADHOC_DLN_MSG />\r\n                         <ADHOC_DLN_TIME />\r\n                     <ADHOC_DLN_UNITS>Days</ADHOC_DLN_UNITS>\r\n                     <ADHOC_RMD_MSG />\r\n                     <ADHOC_RMD_TIME />\r\n                     <ADHOC_RMD_UNITS>Days</ADHOC_RMD_UNITS>\r\n                     <ADHOC_RPT_TIME />\r\n                     <ADHOC_RPT_UNITS>Days</ADHOC_RPT_UNITS>\r\n                     <CIRCULATETO />\r\n                     <COMPLETION />\r\n                     <FOLLOWUP />\r\n                     <MSGSUBJECT />\r\n                     <OTHERFIELD />\r\n                     <PRIORITY>Low</PRIORITY>\r\n                     <REQUEST />\r\n                     <RESPONSE />\r\n                     <Submit />\r\n                     <ADHOC_VALIDDATA>True</ADHOC_VALIDDATA>\r\n                     <JFWF_TRANID>2xxyg9sffane7pwd5j8yv9t49s.1</JFWF_TRANID>\r\n                     <JFWF_INSTRUCTION>Initiate a General Request. Fill the request form, then identify the next participant.</JFWF_INSTRUCTION>\r\n                     <JFWF_TRANSPORT>HTTP</JFWF_TRANSPORT>\r\n                     <JFWF_STATUS>RECEIVED</JFWF_STATUS>\r\n                     <JFWF_ACTION />\r\n                     <JFWF_CHOICE>*Select Next Participant,Cancel</JFWF_CHOICE>\r\n                     <JFWF_VERSION>6.2</JFWF_VERSION>\r\n                     <JFWF_READONLY>1</JFWF_READONLY>\r\n                  </data>\r\n               </xfa:DataGroup>\r\n            </xfa:Data>\r\n         </jfxpf:Content>\r\n      </jfxpf:Resource>\r\n   </jfxpf:Package>\r\n</jfxpf:XPF>";
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new InputSource(new StringReader(xml)));
        assertNotNull(doc);
    }

}