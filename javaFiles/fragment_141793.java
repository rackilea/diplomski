public static void main(String[] args) throws NoSuchFieldException,
        SecurityException {
    List<Integer> list = new ArrayList<Integer>();
    MyObject myObject = new MyObject();
    myObject.setList(list, Integer.class);

    System.out.println(myObject.getType());
}