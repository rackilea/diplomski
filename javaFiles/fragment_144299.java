public class SpecialComparator implements Comparator<Special> {

    private String key;

    public SpecialComparator(String key) {
        this.key = key;
    }

    @Override
    public int compare(Special o1, Special o2) {
        // manage cases where o1 or o2 do not contains key
        return o1.hashMap.get(key).compareTo(o2.hashMap.get(key));
    }

}