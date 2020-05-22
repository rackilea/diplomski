public class Mammal
{
    @WebMethod
    public List<? extends Mammal> getAll() { return null; }
}

public class Human extends Mammal {
    @WebMethod
    public List<Human> getAll() { return null; }
}