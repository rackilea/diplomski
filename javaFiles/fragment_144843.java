public class MyRepository {

    @GraphQLQuery //not commented out
    public MyCayenneClass find(Integer in) {
        return new MyCayenneClass();
    }
}

// extends CayenneDataObject because I don't know where to get the 
// writeProperty and readProperty from
// but shouldn't change anything from SPQR's perspective
public class MyCayenneClass extends CayenneDataObject {
    public static final Property<Integer> A_PROPERTY = Property.create("aProperty", Integer.class);
    public static final Property<String> ANOTHER_PROPERTY = Property.create("anotherProperty", String.class);

    public void setAProperty(Integer aProperty) {
        writeProperty("aProperty", aProperty);
    }

    public Integer getAProperty() {
        return (Integer)readProperty("aProperty");
    }

    public void setAnotherProperty(String anotherProperty) {
        writeProperty("anotherProperty", anotherProperty);
    }

    public String getAnotherProperty() {
        return (String)readProperty("anotherProperty");
    }
}