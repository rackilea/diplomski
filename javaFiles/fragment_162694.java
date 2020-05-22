private static class MyClass {
        int id;
    public MyClass(int i) {
        id = i;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "" + id;
    }

    public void setId(int i) {
        id = i;
    }
}

public static void main(String[] args) {
    Vector<MyClass> old = new Vector<MyClass>();

    old.add(new MyClass(1));
    old.add(new MyClass(2));
    old.add(new MyClass(3));
    Vector<MyClass> newVec = new Vector<MyClass>(old);
    old.get(0).setId(1000);
    System.out.println(Arrays.toString("old "+old.toArray()));
    System.out.println(Arrays.toString("newVec "+newVec.toArray()));
}