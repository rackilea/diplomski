public class T1
{
    public ArrayList<T2> info;
}

public class T2
{
    public String name;
    public String storeCode;  
    public String deptID;    
    public String location;
    public String geography;
    public String team_number;
    public String country;
    public String state;
    public String city;
    public Address address;
    public String passcode;
    public Telephone telephone;
    public OperationTime operationTimings;
    public Links links;
    public Picture picture;
}

public class Address 
{
    public ArrayList<String> storeAdd;
}

public class Telephone 
{
    public String landline;
}

public class OperationTime 
{
    public String Monday;
    public String Tuesday;
    public String Friday;
    public String Wednesday;
    public String Thursday;
    public String Sunday;
    public String Saturday;
}

public class Links
{
    public String myStInfo;
    public String appointments;
    public String directions;
}

public class Picture
{
    public String http;
    public String https;
}