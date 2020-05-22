Beach.java

public class Beach {

    private String name;
    private String city;


    public Beach(String name, String city){
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
Using Beach.java in Jython

>>> import Beach
>>> beach = Beach("Cocoa Beach","Cocoa Beach")
>>> beach.getName()
u'Cocoa Beach'
>>> print beach.getName()
Cocoa Beach