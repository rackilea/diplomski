package com.xx.yy.Main;
import com.aa.bb.OtherClass.Status; // <-- Other class in other package

public class Main {
    public static void main(String[] args) {
        System.out.println(Status.SUCCESS.name());
    }
}