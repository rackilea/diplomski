@Root(name = "Criteria")
public class Criteria
{
    @Attribute(name = "Type")
    private String type;
    @Attribute(name = "Source")
    private String source;
    @ElementList(name = "Values", inline = true)
    private ArrayList<Value> values;



    public Criteria(String type, String source)
    {
        this.type = type;
        this.source = source;
        this.values = new ArrayList<>();
    }

    private Criteria() { }


    // ...


    @Override
    public String toString()
    {
        return "Criteria{" + "type=" + type + ", source=" + source + ", values=" + values + '}';
    }


    // Inner class for values - you also can use a normal one instead
    @Root(name = "Value")
    public static class Value
    {
        @Attribute(name = "Type", required = true)
        private int type;
        @Text(required = true)
        private double value;


        public Value(int type, double value)
        {
            this.type = type;
            this.value = value;
        }

        private Value() { }

    } 

}