public class House
{
    private String  townName;
    private String  ownerName;

    public House (Town inTown, Person owner)
    {
        this.townName = inTown.getName();
        this.ownerName = owner.getName();
    }
    public String getTownName()
    {
        return this.townName;
    }
}