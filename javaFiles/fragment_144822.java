import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLReader {

    public static void main(String[] args) {
        String StrPayload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
                + "<group><UPSSecurity><UsernameToken><Username>pramitjain</Username><Password>wismo123</Password></UsernameToken><ServiceAccessToken><AccessLicenseNumber>9CDEB6D8DEFC2976</AccessLicenseNumber></ServiceAccessToken></UPSSecurity><ShipmentRequest><ns1:Request xmlns:ns1=\"http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0\"><ns1:RequestOption>nonvalidate</ns1:RequestOption></ns1:Request><Shipment><ReturnService><Code>9</Code></ReturnService><Shipper><Name>Barak Obama</Name><ShipperNumber>E3F300</ShipperNumber><Address><AddressLine>151 Union St</AddressLine><AddressLine/><AddressLine/><City>San Francisco</City><StateProvinceCode>CA</StateProvinceCode><PostalCode>94111</PostalCode><CountryCode>US</CountryCode></Address></Shipper><ShipTo><Name>Pottery Barn Kids</Name><Address><AddressLine>10153 Monroe Dr</AddressLine><AddressLine/><City>Dallas</City><StateProvinceCode>TX</StateProvinceCode><PostalCode>75229</PostalCode><CountryCode>US</CountryCode></Address></ShipTo><ShipFrom><Name>Barak Obama</Name><Address><AddressLine>151 Union St</AddressLine><AddressLine/><AddressLine/><City>San Francisco</City><StateProvinceCode>CA</StateProvinceCode><PostalCode>94111</PostalCode><CountryCode>US</CountryCode></Address></ShipFrom><PaymentInformation><ShipmentCharge><Type>01</Type><BillShipper><AccountNumber>E3F300</AccountNumber></BillShipper></ShipmentCharge></PaymentInformation><Service><Code>03</Code><Description>UPS Ground</Description></Service><Package><Description>Self Service Return</Description><Packaging><Code>02</Code></Packaging><PackageWeight><UnitOfMeasurement><Code>LBS</Code></UnitOfMeasurement><Weight>51</Weight></PackageWeight><ReferenceNumber><BarCodeIndicator>1</BarCodeIndicator><Value>W191006849</Value></ReferenceNumber></Package></Shipment><LabelSpecification><LabelImageFormat><Code>GIF</Code></LabelImageFormat></LabelSpecification></ShipmentRequest></group>";
        //Get DOM
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        DocumentBuilder db;
        Document xml;
        String value = null;
        try {
            db = dbf.newDocumentBuilder();
            xml = db.parse(new ByteArrayInputStream(StrPayload.getBytes("utf-8")));
            value = (String) xpath.evaluate("/group/ShipmentRequest/Shipment/Package/ReferenceNumber/Value", xml, XPathConstants.STRING);
        } catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException e) {
            e.printStackTrace();
        }
        System.out.println(value);
    }    
}