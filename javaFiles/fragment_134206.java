public class ItemClass {
private String name;
private String value;

public ItemClass(String name1, String value1) {
    name = name1;
    value = value1; 
}

@Override
public String toString()
{
    return name;
}

public String getValue() {
    return value;
}
}