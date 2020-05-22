public static void main() 
{
    Map<String, List<Double>> map = new HashMap<String, List<Double>>();
    map.put("prices", new ArrayList<Double>(Arrays.asList(1.1, 2.2, 3.3)));

    setData(map);
}

public static void setData(Map<String,? extends List<? extends Serializable>> map)      
{
}