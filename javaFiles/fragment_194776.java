static String getData(int key)
{
    Integer ceiling_key= map.ceilingKey(key);
    Integer floor_key = map.floorKey(key);

    if(ceiling_key == null || floor_key == null)
        return null;

    String value1 = map.get(ceiling_key);
    String value2 = map.get(floor_key);

    if(value1.equals(value2))
        return value1;
    else
        return null;

}