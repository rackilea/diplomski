ex1.add(new obj1("exa1","exb1", new ArrayList<obj2>() ));
ex1.add(new obj1("exa2","exb2", new ArrayList<obj2>() ));
ex1.add(new obj1("exa3","exb3", new ArrayList<obj2>() ));
Collections.sort(ex1);

int a = Collections.binarySearch(ex1,new obj1("exa1",null, new ArrayList<obj2>() )) ;

public class obj1 implements Comparable<obj1>
{
String a;
String b;
ArrayList<obj2> myobj2

public obj1(String a, String b, ArrayList<obj2> myobj2)
    {
     this.a = a;
     this.b = b;
     this.myobj2 = myobj2;
    }
   public String geta(){return a;}
   public String getb(){return b;}
   public ArrayList<obj2> getmyobj2(){return myobj2;}
   public int compareTo(obj1 anB)
    {
    return getb().compareTo(anB.getb());
    }
}