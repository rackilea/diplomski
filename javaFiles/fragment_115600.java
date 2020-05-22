package iseji.app.main;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]){
        Map<String, ClassC> myMap = new HashMap<String, ClassC>();
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        myMap.put("1", classA);
        myMap.put("2", classB);

        ClassC classC = myMap.get("1");
        if(classC instanceof ClassA){
            System.out.println("Is A");
            classC.printClassName();
            ((ClassA) classC).myClassAMethod();
        }else{
            System.out.println("Is B");
            classC.printClassName();
            ((ClassB) classC).myClassBMethod();
        }

    }
}