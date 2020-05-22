@Root
@Convert(WorldObjectConverter.class) // specify converter for this class
public class WorldObject
{
    @Element(name = "vector-names")
    private List<List<String>> vectorNames;

    // only for the example below - write whatever constructor(s) you need
    public WorldObject()
    {
        this.vectorNames = new ArrayList<>();
    }

    // constructor, getter / setter, etc.


    // a getter is required to access the field in the converter.
    public List<List<String>> getVectorNames()
    {
        return vectorNames;
    }
}