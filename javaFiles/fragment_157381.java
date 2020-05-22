public static void main(String[] args) {

    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

    map.put("Hello", Arrays.asList(1,2,3));
    map.put("World", Arrays.asList(4,5));

    System.out.println(getNumOfValuesPerKey(map));
}