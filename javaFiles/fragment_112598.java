public class Thing
{
   private String name;
   private int    num;

   public Thing(String name, int num)
   {
       this.name = name;
       this.num  = num;
   } 
}

public class ThingMap
{
    Map<String, Integer> thingMap; 

    public ThingMap()
    {
       this.thingMap = new HashMap<>();
    }

    public void put(Thing t)
    {
       String  k = t.getName();
       Integer v = t.getNum();

       if(thingMap.get(k) == null) //no entry exists
       {
          thingMap.put(k, v);
       }
       else //entry exists
       {
          //add to the current value
          thingMap.put(k, thingMap.get(k) + v);
       }
    }

    public Integer get(String k)
    {
       return this.thingMap.get(k);
    }
}

public class TestThing
{
   public static void main(String[] args)
   {
      ThingMap tMap = new ThingMap();
      Thing a = new Thing("Star Wars", 3);
      Thing b = new Thing("Star Wars", 1);

      tMap.put(a);
      tMap.put(b);

      System.out.println("Current value: " + tMap.get(a.getName());
   }

}