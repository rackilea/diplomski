package com.mycompany.demo;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
  public static void main(String args[]) {
    QName serviceName = new QName("http://org.apache.cxf", "stockQuoteReporter");
    Service s = Service.create(serviceName);

    QName portName = new QName("http://org.apache.cxf", "stockQuoteReporterPort");
    Dispatch<DOMSource> dispatch = s.createDispatch(portName,
                                                  DOMSource.class,
                                                  Service.Mode.PAYLOAD);
    ...
  }
}