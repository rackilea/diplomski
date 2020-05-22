public class Main {

    public static class MyObject {

        public int value;

        @Override
        public String toString() {
            return "MyObject [value=" + value + "]";
        }

    }

    public static void main(String str[]) throws IOException {
        Set<MyObject> myObjects = new TreeSet<MyObject>(
                new Comparator<MyObject>() {

                    public int compare(MyObject object1, MyObject object2) {
                        return object1.value - object2.value;
                    }
                });

        addMyObjects(myObjects);
        addMyObjects(myObjects); // try to add the duplicates

        System.out.println(myObjects);
    }

    private static void addMyObjects(Set<MyObject> set){
        for (int i = 0; i < 5; i++) {
            MyObject myObject = new MyObject();
            myObject.value = i;
            set.add(myObject);
        }
    }
}