package test;

import org.springframework.stereotype.Service;

@Service
public class B {

    public StringBuilder getStringNextValue() {
        StringBuilder str = new StringBuilder();
        str.append(" World");
        System.out.println(str.toString()); // Here i get ' World' -> zp: Yes, 2 times
        return str;
    }
}