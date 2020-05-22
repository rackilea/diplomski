public class House
{
    public final String area;

    public windows;
    public int doors;
    public int rooms;
}

interface HouseBuilder 
{ 
    public HouseBuilder area(); 

    public HouseBuilder windows(); 

    public HouseBuilder doorsors(); 

    public HouseBuilder rooms(); 

    public House build(); 
} 

public static class DowntownHouseBuilder implements HouseBuilder
{   
    House downtownHouse = new House();

    public HouseBuilder area()
    {
        downtownHouse.area = "Downtown";
    }

    public HouseBuilder windows()
    {
        downtownHouse.windows = 3;
        return this;
    }

    public HouseBuilder doors()
    {
        downtownHouse.doors = 2;
        return this;
    }

    public HouseBuilder rooms()
    {
        downtownHouse.rooms = 2;
        return this;
    }

    public House build()
    {
        return downtownHouse;
    }
}

public static class VilaBuilder implements HouseBuilder
{   
    House vila new House();

    public HouseBuilder area()
    {
        vila.area = "Downtown";
    }

    public HouseBuilder windows()
    {
        vila.windows = 24;
        return this;
    }

    public HouseBuilder doors()
    {
        vila.doors = 5;
        return this;
    }

    public HouseBuilder rooms()
    {
        downtownHouse.rooms = 10;
        return this;
    }

    public House build()
    {
        return vila;
    }
}

class Driector  
{ 
    private HouseBuilder houseBuilder; 

    public Driector(HouseBuilder houseBuilder) 
    { 
        this.houseBuilder = houseBuilder; 
    } 

    public House buildHouse() 
    { 
        return this.houseBuilder.area()
                                .windows()
                                .doors()
                                .rooms()
                                .buid();            
    } 
}

class HouseConstruction
{ 
    public static void main(String[] args) 
    {
        Director director = new Director(new VilaBuilder()); 

        House house = director.buildHouse(); 

        System.out.println("Builder constructed: "+ house); 
    } 
}