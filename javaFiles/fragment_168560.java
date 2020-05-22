import java.util.ArrayList;

import java.util.List;

import javax.xml.parsers.SAXParser;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {
    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.getAreaXml();
    }

    public void getAreaXml() {
        final List<StringBuilder> first = new ArrayList<StringBuilder>();
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler defaultHandler = new DefaultHandler() {
                Boolean wojTag = false;
                Boolean powTag = false;
                Boolean gmiTag = false;
                Boolean rodzTag = false;
                Boolean nazwaTag = false;
                Boolean nazdodTag = false;
                Boolean stan_naTag = false;

                public void startElement(String uri, String localName,
                        String qName, Attributes attributes)
                        throws SAXException {

                    if (qName.equalsIgnoreCase("col")) {
                        if (attributes.getValue(0) != null)
                            if (attributes.getValue(0).equalsIgnoreCase("WOJ"))
                                wojTag = true;

                        if (attributes.getValue(0) != null)
                            if (attributes.getValue(0).equalsIgnoreCase("POW"))
                                powTag = true;

                        if (attributes.getValue(0) != null)
                            if (attributes.getValue(0).equalsIgnoreCase("GMI"))
                                gmiTag = true;

                        if (attributes.getValue(0) != null)
                            if (attributes.getValue(0).equalsIgnoreCase("RODZ"))
                                rodzTag = true;

                        if (attributes.getValue(0) != null)
                            if (attributes.getValue(0)
                                    .equalsIgnoreCase("NAZWA"))
                                nazwaTag = true;

                        if (attributes.getValue(0) != null)
                            if (attributes.getValue(0).equalsIgnoreCase(
                                    "NAZDOD"))
                                nazdodTag = true;
                        if (attributes.getValue(0) != null)
                            if (attributes.getValue(0).equalsIgnoreCase(
                                    "STAN_NA"))
                                stan_naTag = true;
                    }
                }

                public void characters(char ch[], int start, int length)
                        throws SAXException {

                    StringBuilder temp = new StringBuilder();

                    if (wojTag.equals(true)) {

                        temp.append(new String(ch, start, length));
                        temp.append("  ");
                    }
                    if (powTag.equals(true)) {

                        temp.append(new String(ch, start, length));
                        temp.append("  ");
                    }
                    if (gmiTag.equals(true)) {

                        temp.append(new String(ch, start, length));
                        temp.append("  ");
                    }
                    if (rodzTag.equals(true)) {

                        temp.append(new String(ch, start, length));
                        temp.append("  ");
                    }
                    if (nazwaTag.equals(true)) {

                        temp.append(new String(ch, start, length));
                        temp.append("  ");
                    }
                    if (nazdodTag.equals(true)) {

                        temp.append(new String(ch, start, length));
                        temp.append("  ");
                    }
                    if (stan_naTag.equals(true)) {

                        temp.append(new String(ch, start, length));
                        temp.append("  ");
                    }

                    first.add(temp);
                }

                public void endElement(String uri, String localName,
                        String qName) throws SAXException {

                    if (qName.equalsIgnoreCase("col")) {
                        wojTag = false;
                    }
                    if (qName.equalsIgnoreCase("col")) {
                        powTag = false;
                    }
                    if (qName.equalsIgnoreCase("col")) {
                        gmiTag = false;
                    }
                    if (qName.equalsIgnoreCase("col")) {
                        rodzTag = false;
                    }
                    if (qName.equalsIgnoreCase("col")) {
                        nazwaTag = false;
                    }
                    if (qName.equalsIgnoreCase("col")) {
                        nazdodTag = false;
                    }
                    if (qName.equalsIgnoreCase("col")) {
                        stan_naTag = false;
                    }
                }
            };

            saxParser.parse("E:/ResourcePDF/zippertest/src/test.xml",
                    defaultHandler);

            for (StringBuilder s : first) {
                System.out.print(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}