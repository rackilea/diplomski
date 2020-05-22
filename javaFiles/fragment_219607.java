class alienPet{ // It is recommended you use the java naming convention.
    Alien myAlien = new Alien();
    // alienPet a = new alienPet();
    // a.myAlien; // you could potentially do this to get an alien from an alienPet class
    void someVoid(){
        Alien otherAlien;
    }
    void errorVoid(){
        otherAlien.toString(); 
// causes an error, the otherAlien variable is never visible to errorVoid as it is a local variable
        myAlien.toString(); // OK
    }
}