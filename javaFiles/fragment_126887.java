volatile int counter;

public incrementSomeValue(){
    counter++; // Bad thread juju - this is at least three instructions 
               // read - increment - write             
               // there is no guarantee that this operation is atomic
}