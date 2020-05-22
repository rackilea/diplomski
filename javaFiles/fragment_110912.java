/*
 *  Worker class, basic type with variables, constructor, and toString() overridden
 *  Here I have implemented Serializable for the reason that I need to make sure that
 *  I will serialize the object within the class
 *
 *  Note that I used transient for id. transient is a special keyword which makes sure 
 * that id will not be serialized, used for security reasons.
 * 
 *  serialVersionUID is another variable which is used during deserialization 
 * to verify that the sender and receiver of a serialized object have loaded 
 * classes for that object that are compatible with respect to serialization. 
 *  Throws InvalidClassException if the object has a different serialVersionUID
 * than that of the corresponding sender's class.
 *  
 */

import java.io.*;
class Worker implements Serializable{

private static final long serialVersionUID = 1L;
private String name;
private transient int id;
private double wage;

public Worker(String name, int id, double wage){
    this.name = name;
    this.id = id;
    this.wage = wage;
}
public String toString(){
    return "Person with name " +
    name + " and with id " +
    id + " has a salary of " + wage + "$";
    }
}