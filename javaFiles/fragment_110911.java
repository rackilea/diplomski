package Chaper8.IO;

import java.io.*;

import java.util.*;

public class Serialization_Deserialization {

public static void main(String [] args){

    /*
     *  try-catch with resources, JVM makes sure to close the resources after you've finished using it
     * much easier than using finally and getting an exception for each resource closed
     * 
     */
    try(FileOutputStream out = new FileOutputStream("C:\\Users\\Andrei\\Desktop\\Exemple\\worker.txt");
        ObjectOutputStream oos = new ObjectOutputStream(out);

        FileInputStream in = new FileInputStream("C:\\Users\\Andrei\\Desktop\\Exemple\\worker.txt");
        ObjectInputStream ois = new ObjectInputStream(in);){

        //instances of the Worker class
        Worker w1 = new Worker("Worker1", 123456 , 2000.5);
        Worker w2 = new Worker("Worker2", 765436, 1500.15);
        Worker w3 = new Worker("Worker3", 364582, 1700.45);
        Worker w4 = new Worker("Worker4", 878234, 2100.34);
        ArrayList<Worker> list = new ArrayList<>();

        //just adding the persons in the list
        list.add(w1);
        list.add(w2);
        list.add(w3);
        list.add(w4);


        System.out.println("Doing serialization");
        oos.writeObject(list);

        System.out.println("Doing deserialization");
        ois.readObject();

    }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
    }
}
}