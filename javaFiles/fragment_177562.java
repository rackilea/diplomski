package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {

    @Autowired
    private B b;

    public String getStringValue() {
        StringBuilder str = new StringBuilder("Hello ");
        str.append(b.getStringNextValue()); // zp: This line prints ' World' AND make str = 'Hello World'
        System.out.println(b.getStringNextValue()); // here nothing as output but expectation is ' World' -> zp: Prints ' World'
        System.out.println(str); // here i only get 'Hello ' But expectation is 'Hello World' -> zp: 'Hello World' is printed
        return str.toString();
    }
}