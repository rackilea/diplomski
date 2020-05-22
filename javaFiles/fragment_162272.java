package com.company.function;

import com.company.pojo.ExamplePojo;

public class SetValue {

  public ExamplePojo setValue(){

    ExamplePojo EP = new ExamplePojo();

    EP.setX(10);
    EP.setY(20);
    EP.setZ(30);
    EP.setC("Saurabh");
    EP.setA("mahaesh");
    EP.setB("Kanni");

    return EP;
  }

}