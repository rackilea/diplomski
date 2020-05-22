class MyClass<K> {
    Map<K,Float> myMap;
}
class Derived extends MyClass<Integer>{
    void SparsePDT(int size){
        myMap = new HashMap<Integer,Float>();
        Integer bar = 0;
        while(bar<size){
            Float rnd = ThreadLocalRandom.current().nextFloat();
            myMap.put(bar,rnd);
            bar++;
        }
    }
}