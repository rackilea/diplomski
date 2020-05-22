public class Fake implements Comparable<Integer>{

    public int compareTo(Integer i){
        return i.compareTo(1);
    }

    public static <T extends Comparable> T findMax2(List<T> list, int first, int second) {
        T max = list.get(first);
        for (int i = first+1; i < second; i++) {
            if (list.get(i).compareTo(max)>0) max = list.get(i);
        }
        return max;
    }

    public static void main(String[] args){
        Fake fake = new Fake();
        List<Comparable<Integer>> l =  new ArrayList<>();
        l.add(fake);
        l.add(1);
        l.add(3);
        l.add(6);
        findMax2(l, 0, l.size()-1);
    }
}