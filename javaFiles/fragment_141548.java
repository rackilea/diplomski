package net.betlista.gson;

public class Person {

    private String name;
    private String surname; // no setter

    public String getName() {
        System.out.println( "Person#getName()" );
        return name;
    }

    public void setName( final String name ) {
        this.name = name;
    }

}