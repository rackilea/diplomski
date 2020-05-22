public static void main(String[] args) throws java.lang.Exception {
    List<Integer> list = new ArrayList<Integer>();
    for(int i = 0; i < 10; i++) {
       list.add(new Random().nextInt(30) + 1);
    }
    System.out.println(formatMyList(list));
}

public static String formatMyList(List list){
    String str = list.toString().replace("[", "{");
    str = str.replace("]", "}");
    str = str.replace(",", " -");
    return str;
}