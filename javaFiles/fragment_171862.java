double[] priorities = new double[10];
for (int i = 0; i < priorities.length; i++) 
    priorities[i] = Math.round(10*Math.random());
Arrays.sort(priorities, new ArrayIndexComparator());

...
...

public class ArrayIndexComparator implements Comparator<Double> {
    @Override
    public int compare(Double d1, Double d2) {
        return -1*d1.compareTo(d2);
    }
}