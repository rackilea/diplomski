public class Main {
    public static void main (String[] args) {

        Comparator<CustomObject> sortOn3rdValue = new Comparator<CustomObject>() {
            @Override
            public int compare(CustomObject o1, CustomObject o2) {
                return o1.v3 < o2.v3 ? -1 : o1.v3 > o2.v3 ? 1 : 0;
            }
        };

        Set<CustomObject> objects = new TreeSet<CustomObject>(sortOn3rdValue);

        String[] arr = { "200,400,7,1", "100,0,1,1", "200,200,3,1", "0,400,11,1", "407,308,5,1", "100,600,9,1" };

        for(String a : arr) {
            objects.add(new CustomObject(a.split(",")));
        }

        for(CustomObject co : objects) {
            System.out.println(co);
        }
    }
}

class CustomObject {

    final int v1, v2, v3, v4;

    CustomObject(String[] strValues) {
        // assume strValues.lenght == 4
        v1 = Integer.valueOf(strValues[0]);
        v2 = Integer.valueOf(strValues[1]);
        v3 = Integer.valueOf(strValues[2]);
        v4 = Integer.valueOf(strValues[3]);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d,%d)", v1, v2, v3, v4);
    }
}