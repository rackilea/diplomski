/**
JMathur
*/

package com.org.test1;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class XMLBuilder {
public static void main(String args[]) {
    Sales object = new Sales();
    object.setSales("sales");

    Product p1 = new Product();
    Product p2 = new Product();

    Column c1 = new Column();
    Column c2 = new Column();
    Column c3 = new Column();
    c1.setName("id");
    c1.setValue("1");
    c2.setName("name");
    c2.setValue("Product_Name");
    c3.setName("qty");
    c3.setValue("10");

    List<Column> listColumn=new ArrayList<Column>();
    listColumn.add(c1);
    listColumn.add(c2);
    listColumn.add(c3);

    p1.setTableName("product");
    p1.setColumn(listColumn);

    p2.setTableName("product");
    p2.setColumn(listColumn);

    List<Product> list = new ArrayList<Product>();
    list.add(p1);
    list.add(p2);

    object.setProducts(list);

    String response=marshal(object);

    Sales salesAfterUnMarshal=(Sales)unmarshal(new StringReader(response), Sales.class);



    System.out.println("Marshalling====="+response);

    System.out.println("Unmarshalling==="+salesAfterUnMarshal.getProducts());
}

public static <T> String marshal(T object) {

    StringWriter response = new StringWriter();
    try {
        JAXBContext jaxbContext = JAXBContext
                .newInstance(object.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller
                .setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        jaxbMarshaller.marshal(object, response);

    } catch (JAXBException jxbException) {
        throw new RuntimeException(jxbException.getMessage(), jxbException);
    }
    return response != null ? response.toString() : null;

}
public static <T> T unmarshal(Reader reader, Class<T> clazz) {
    T classInstance = null;
    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new StreamSource(reader));
        classInstance = clazz.cast(object);
    } catch (JAXBException jxbException) {
    //  throw new RuntimeException(errorMessage, jxbException);
    }
    catch (Exception jxbException) {
    //  throw new RuntimeException(errorMessage, jxbException);
    }
    return classInstance;
}
}