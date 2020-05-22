class MyStringArrayHolder {
    private final String[] data;
    //I do not want any client could change the array reference
    //this also explains why this field doesn't have a setter
    public MyStringArrayHolder(String[] data) {
        this.data = data;
    }
    public String[] getData() {
        return this.data;
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof MyStringArrayHolder) {
            MyStringArrayHolder other = (MyStringArrayHolder)o;
            return Arrays.equals(this.data, other.data);
        }
        return false;
    }
    //just to print in console for testing purposes
    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }
}

public class PathingData {
    //removed the static modifier, not really sure why you need it like that
    public Map<MyStringArrayHolder, List<int[]>> allEntityData;
    //current class implementation...
    //just to print in console for testing purposes
    @Override
public String toString() {
    return allEntityData.toString();
}
public static void main(String[] args) {
    PathingData pathingData = new PathingData();
    String[] example1 = { "hello", "world" };
    String[] example2 = { "luiggi", "mendoza" };
    String[] example3 = { "hello", "world" };
    MyStringArrayHolder holder1 = new MyStringArrayHolder(example1);
    MyStringArrayHolder holder2 = new MyStringArrayHolder(example2);
    MyStringArrayHolder holder3 = new MyStringArrayHolder(example3);
    pathingData.addEntity(holder1);
    pathingData.addEntity(holder2);
    pathingData.addEntity(holder3);
    pathingData.addData(holder1, "1,2,3");
    pathingData.addData(holder2, "4,5,6");
    pathingData.addData(holder3, "7,8,9");
    System.out.println(pathingData);
}
}