public class Factory 
{
    private String name;
    private String payload;

    public Factory setName(final String name)
    {
        this.name = name;
    }

    public Factory setPayload(final String payload)
    {
        this.payload = payload;
    }

    public DataObject build()
    {
        DataObject newObj = new DataObject();
        newObj.setName( this.name );
        newObj.setPayload( this.payload );
        return newObj;
    }

    public class DataObject
    {
        // fields and setters, ALL PRIVATE
    }
}