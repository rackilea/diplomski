public static void main(String[] args) {
    String eq = "4/2+32*4*2-1";

    String[] eqList = eq.split("(?<=[+*-/])|(?=[+*-/])");

    ArrayList<String> list = new ArrayList<String>();

    for (int i = 0; i < eqList.length; i++) {
        list.add(eqList[i]);
    }

    int a = Integer.parseInt(list.get(0));
    System.out.println(a);
}