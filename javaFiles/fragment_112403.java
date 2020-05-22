import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ProductsDump {
    static Products products = new Products();
    static
    {
        products.setProducts(new ArrayList<>()); 
        Product prod1 = new Product();
        prod1.setName("Hamburger");
        prod1.setPrice(10);
        Product prod2 = new Product();
        prod2.setName("Bretzel");
        prod2.setPrice(5);
        products.getProducts().add(prod1);
        products.getProducts().add(prod2);
    }
    private static void marshalingExample() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the products list in console
        jaxbMarshaller.marshal(products, System.out);

        //Marshal the products list in file
        jaxbMarshaller.marshal(products, new File("c:/products.xml"));
    }

    public static void main(String[] args) throws Exception {
        marshalingExample();
    }
}