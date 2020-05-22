import java.util.HashMap;
import java.util.Map;

enum Type {
     WEB_TYPE1("T1", "Web Type 1"),
     WEB_TYPE2("T2", "Web Type 2"),
     MOBILE_TYPE1("T3", "Mobile Type 1"),
     MOBILE_TYPE2("T4", "Mobile Type 2");

    private String type;
    public String getType() {
        return type;
    }


    public String getName() {
        return name;
    }


    private String name;


    Type(String type,String name) {
        this.type = type;
        this.name = name;
    }

}
public class SeparateHash {

    public static void main(String[] args) {
        Map<String, String> webMap = new HashMap<>();
        Map<String, String> mobileMap = new HashMap<>();
          for (Type status : Type.values()) {
                System.out.println(status);
                if(status.toString().startsWith("WEB_")){
                    webMap.put(status.toString(), status.getName());
                }else{
                    mobileMap.put(status.toString(), status.getName());
                }
            }




Map<String, String> map = webMap;
for (Map.Entry<String, String> entry : map.entrySet())
{
    System.out.println(entry.getKey() + "   " + entry.getValue());
}

Map<String, String> map2 = mobileMap;
for (Map.Entry<String, String> entry : map2.entrySet())
{
    System.out.println(entry.getKey() + "    " + entry.getValue());
}


    }

}