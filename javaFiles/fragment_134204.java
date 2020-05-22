public class SomeConcretePerson extends Person
{
    public SomeConcretePerson (SomeConcretePerson another)
    {
        super (another); // this will invoke Person's copy constructor
    }

    public Object clone()
    {
        return new SomeConcretePerson(this);
    }
}