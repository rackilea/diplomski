public class Values
{
    private String value;

    private String feature;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getFeature ()
    {
        return feature;
    }

    public void setFeature (String feature)
    {
        this.feature = feature;
    }
}

public class Definition
{
    private Values[] values;

    public Values[] getValues ()
    {
        return values;
    }

    public void setValues (Values[] values)
    {
        this.values = values;
    }
}

public class MyPojo
{
    private Definition definition;

    private String[] stuff;

    private String some_class;

    public Definition getDefinition ()
    {
        return definition;
    }

    public void setDefinition (Definition definition)
    {
        this.definition = definition;
    }

    public String[] getStuff ()
    {
        return stuff;
    }

    public void setStuff (String[] stuff)
    {
        this.stuff = stuff;
    }

    public String getSome_class ()
    {
        return some_class;
    }

    public void setSome_class (String some_class)
    {
        this.some_class = some_class;
    }
}