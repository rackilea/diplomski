package de.fhb.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Application {
    public static List<String> methodReturningList() {
        return new ArrayList<String>();
    }

    public static ArrayList<String> methodReturningArrayList() {
        return new ArrayList<String>();
    }

    public static LinkedList<String> methodReturningLinkedList() {
        return new LinkedList<String>();
    }

    public static Vector<String> methodReturningVector() {
        return new Vector<String>();
    }

    public static void main(String[] args) {
        methodReturningList();
        methodReturningArrayList();
        methodReturningLinkedList();
        methodReturningVector();
    }
}