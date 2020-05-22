public static void getMeListOfObjs(List<? extends Object> al) {
    System.out.println(al.get(0));
}

public static void main(String[] args) {

    List<String> al = new ArrayList<String>();

    String mys1 = "jon";

    al.add(mys1);

    getMeListOfObjs(al);


}