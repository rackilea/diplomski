public class BicycleDataStructure<T extends Bycycle & Comparable<T>> {

    protected List<T> dataStructure;

    protected T max;

    public BicycleDataStructure() {
        this.dataStructure = new ArrayList<>();
        this.max = null;    
    }

    public void addBicycle(T b1) {
        for (int i = 0; i < dataStructure.size(); i++) {
            T b = dataStructure.get(i);

            if (b1.compareTo(b) < 0) {
                this.dataStructure.add(i, b1);
                break;
            }   
        }    
    }
}