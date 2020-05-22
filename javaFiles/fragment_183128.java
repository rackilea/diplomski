public class MyMap implements Map<String, Double>{
    private final Map<String, Double> map;  

    public MyMap(Map<String, Double> map){
        this.map = map;
    }

    public void putIfGreaterThan(String key, Double value ){...}

    @Override
    public int size() {
        return map.size();
    }

    //inherited methods
}