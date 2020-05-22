class MapStorage{
    List<Map<MapKeyParent, Integer>> mapList;

    public MapStorage() {
       mapList.add(new HashMap<MapKeyParent, Integer>());
       mapList.add(new HashMap<MapKeyParent, Integer>());
    ....
    }

    public void addToMap(int index, MapKeyParent key, Integer value )
    {
       mapList.get(index).put(key, value);
    }

    public Integer getFromMap(int index, MapKeyParent key)
    {
       return mapList.get(index).get(key);
    }
}