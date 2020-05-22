import java.util.Map; 
import java.util.HashMap; 

public enum EnumTest { 
  FOO, BAR, BAZ; 

  private static final Map<String,EnumTest> map = new LinkedHashMap<String,EnumTest>(); 
  static { 
      for(EnumTest e : EnumTest.values())
        map.put(e.name(), e); 
  } 

  public static void main(String... args) { 
    System.out.println(EnumTest.map); 
  } 
}