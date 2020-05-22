public class Weather implements Serializable {


public CityObj city;
public class  CityObj {
    public String name;
    public int id;
    public coordObj coord;
    public String country;
    public String population;
    public sysObj sys;
}

public class coordObj {
    public long lon;
    public long lat;

}
public class sysObj {
    public int population;
}
.
.
.

}