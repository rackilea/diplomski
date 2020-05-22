@XmlRootElement( name = "response" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ObjectWrapper
{
    @XmlElementWrapper( name = "objectWrapper" )
    @XmlElement( name = "myObject" )
    private List<MyObject> myObjects;


    public void setMyObjects( List<MyObject> objects )
    {
        this.myObjects  = objects;
    }

    public List<MyObject> getMyObjects()
    {
        return myObjects;

    }
}