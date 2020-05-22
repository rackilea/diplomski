public class MyKey implements Comparable<MyKey>
{
private Integer i;
private String s;
public MyKey(Integer i,String s)
{
this.i=i;
this.s=s;
}

public Integer getI() { return i;}
public String getS() { return s;}

@Override
public int hashcode()
{
return i.hashcode()+31*s.hashcode();
}

@Override
public boolean equals(Object o)
{
if(o==this) return true;
if(o==null || !(o instanceof MyKey)) return false;
MyKey cp= MyKey.class.cast(o);
return i.equals(cp.i) && s.equals(cp.s);
    }

   public int compareTo(MyKey cp)
     {
     if(cp==this) return 0;
     int i= i.compareTo(cp.i);
     if(i!=0) return i;
     return s.compareTo(cp.s);
     }


 @Override
    public String toString()
       {
       return "("+i+";"+s+")";
       }

    }

public Map<MyKey,String> map= new HashMap<MyKey,String>();
map.put(new MyKey(1,"Hello"),"world");