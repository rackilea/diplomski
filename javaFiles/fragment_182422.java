public static ArrayList<String> foo() {
    ArrayList<String> arrlist = new ArrayList<String>();        
    arrlist.add("asdf");
    return arrlist;
}

public static List<Integer> bar() {
    return (List)foo();
}

public static void main(String[] args) {

    List<Integer> list = bar();     
    System.out.println(list.get(0).doubleValue());
}