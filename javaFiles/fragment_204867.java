public ga_struct mutate(ga_struct parent) //takes in reference to parent
{
    Random r= new Random(); //modifies parent
    ......     do some modification to the parent
    return parent; //return reference to parent
}