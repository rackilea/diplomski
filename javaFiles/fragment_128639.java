public class House
{
    private Town    inTown;
    private Person  owner;

    public House (Town inTown, Person owner)
    {
        this.inTown = inTown;
        this.owner = owner;
    }
    public String getTownName()
    {
        return this.inTown.getName();
    }
}