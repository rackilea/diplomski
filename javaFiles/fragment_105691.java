public class DetailExtractor {

//Arraycontaining alien objects
Alien[] alienRegister = new Alien[100];

public static void main(String[] args){
    //Populating the array
    alienRegister[0] = new Alien(3, "Zorg", "Blue");
    alienRegister[1] = new Alien(5, "Chad", "Purple");


    //Retrieving a property, say name of second alien...

    System.out.println(alienRegister[1].name);

}

}