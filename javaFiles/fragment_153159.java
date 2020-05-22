public class Animal {

    private String name;
    private String id;
    private String country;

    public Animal (String name, String id, String country){
        this.name = name;
        this.id = id;
        this.country = country;
    }

    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public String getId(){
        return id;
    }
}