import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.codehaus.jackson.map.ObjectMapper;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

public class XMLParser  {
    final static class Type {
        private String types;

        public String getTypes() {
            return types;
        }

        public void setTypes(String types) {
            this.types = types;
        }

    }

    final static class Subtype {
        private String sybtype;
        private List<Type> alltests = new ArrayList<Type>();

        public String getSybtype() {
            return sybtype;
        }
        public void setSybtype(String sybtype) {
            this.sybtype = sybtype;
        }
        public List<Type> getAlltests() {
            return alltests;
        }
        public void setAlltests(List<Type> alltests) {
            this.alltests = alltests;
        }

    }

    final static  class product {
        private String product_name;
        private String parameter;
        private List<Subtype> allsubtypes = new ArrayList<Subtype>();

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getProduct_name() {
            return this.product_name;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }

        public List<Subtype> getAllsubtypes() {
            return allsubtypes;
        }

        public void setAllsubtypes(List<Subtype> allsubtypes) {
            this.allsubtypes = allsubtypes;
        }
    }

    public List<product> getDetails() {
        List<product> prods = new ArrayList<product>();
        org.jdom2.Document jdomDoc;
        try {
            jdomDoc = useDOMParser(new File("resource/stackoverflow/Products.xml"));

            List<org.jdom2.Element> products = jdomDoc.getRootElement().getChildren("product");
            for (org.jdom2.Element product : products) {
                product prod = new product();
                prod.setProduct_name(product.getAttributeValue("productsname"));

                List<org.jdom2.Element> subtypes = product.getChild("Parameters").getChildren("Subtype");
                List<Subtype> listsubtype = new ArrayList<Subtype>();

                for (org.jdom2.Element subtype : subtypes) {
                    Subtype subt = new Subtype();
                    subt.setSybtype(subtype.getAttributeValue("name"));

                    List<org.jdom2.Element> types = subtype.getChildren("type");
                    List<Type> listtype = new ArrayList<Type>();

                    for (org.jdom2.Element type : types) {
                        Type typ = new Type();
                        typ.setTypes(type.getText());

                        listtype.add(typ);
                    }
                    subt.setAlltests(listtype);
                    listsubtype.add(subt);

                }

                //prod.setAlltests(listsubtype);
                prod.setAllsubtypes(listsubtype);

                prods.add(prod);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prods;
    }

    private org.jdom2.Document useDOMParser(File fileName)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setIgnoringComments(true);
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(fileName);

        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);

    }

    public static void main(String[] args) {
        XMLParser  xml = new XMLParser ();
        ObjectMapper mapper = new ObjectMapper();
        List<product> prods = new ArrayList<product>();
        prods = xml.getDetails();
        for (product p : prods) {

            try {               
                System.out.println("**********************************************");
                String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
                System.out.println(jsonInString2);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}