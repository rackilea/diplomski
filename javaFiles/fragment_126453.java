public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "test"));
        System.out.println(getCountTheSameLastName(map, "test"));
    }
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> odin = new HashMap<String, String>();
        odin.put("0","test");
        odin.put("1","test");
        odin.put("2","test");
        odin.put("3","test");
        odin.put("4","test");
        odin.put("5","test");
        odin.put("6","test");
        odin.put("7","test");
        odin.put("8","test");
        odin.put("9","test");

        return odin;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for(Map.Entry<String, String> lol : map.entrySet()){

            String value = lol.getValue();
            if(name.equals(value)){
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiy)
    {
        int count=0;
        for (Map.Entry<String,String> pair : map.entrySet())
        {
            String key = pair.getKey();
            if (familiy.equals(key))
            {
                count++;
            }
        }
        return count;
    }
}