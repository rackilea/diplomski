/**
JMathur
 */

package com.org.test1;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
@XmlAttribute(name="name")
private String tableName;


public String getTableName() {
    return tableName;
}

public void setTableName(String tableName) {
    this.tableName = tableName;
}


private  List<Column> column;


public List<Column> getColumn() {
    return column;
}

public void setColumn(List<Column> column) {
    this.column = column;
}



}