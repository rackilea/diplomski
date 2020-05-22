package com.xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class AttributeConverter implements Converter{

  @Override
  public boolean canConvert(Class clazz) {
    return clazz.equals(Attribute.class);
  }

  @Override
  public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
    System.out.println("object = " + object.toString());
    Attribute attribute = (Attribute) object;
    writer.addAttribute("name", attribute.getName());  
    writer.setValue(attribute.getValue());  

  }

  @Override
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    return new Attribute(reader.getAttribute("name"), reader.getValue());

  } 

}