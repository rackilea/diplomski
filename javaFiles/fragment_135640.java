public class multivalueHashmap {
    private Map< Integer, List<Float> > map = new HashMap< Integer, List<Float> >();

    public void add(Integer id, Float value){
        if(!map.containsKey(id)){
            map.put(id, new ArrayList<Float>());
        }
        map.get(id).add(value);
    }

    public void delete(Integer id, Float value){
        if(!map.containsKey(id)){
            return;
        }
        map.get(id).remove(value);
    }
}