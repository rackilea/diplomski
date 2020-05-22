package com.cellfish.mediadb.rest.lucene;

import javax.xml.bind.annotation.XmlElement;

class MapElements
{
  @XmlElement public String  key;
  @XmlElement public Integer value;

  private MapElements() {} //Required by JAXB

  public MapElements(String key, Integer value)
  {
    this.key   = key;
    this.value = value;
  }
}