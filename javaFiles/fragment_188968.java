private List<String> list = new ArrayList<>();
private ListIterator<String> itr = list.listIterator(); //at this point mod count is 0

public static void load(String sourceName){
        list.add("Foo");// increment mod count by 1
}