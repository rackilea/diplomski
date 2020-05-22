public static void main(String[] args) {
    Object[] obj = new Object[2];
    printObject(obj, 1);
}

public static void printObject(Object[] objects, int index){
    if (index == 0 || index == 1) {
        System.out.println(objects[index].toString());
    }
}