/**
JMathur
 */

package com.org.test1;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="database")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sales {

@XmlElement(name="table")
List<Product> products;

@XmlAttribute(name="names")
private String sales;

public String getSales() {
    return sales;
}

public void setSales(String sales) {
    this.sales = sales;
}

public List<Product> getProducts() {
    return products;
}

public void setProducts(List<Product> products) {
    this.products = products;
}


}