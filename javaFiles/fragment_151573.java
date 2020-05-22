List<MyClass> list = new ArrayList<MyClass>();
list.add(new MyClass("Hello", 1, 2, 3);
list.add(new MyClass("World", 4, 5, 6);
MyClass mc = list.get(0);
for(MyClass myClass : list)
{
    android.util.Log.i(getClass().getSimpleName(), "Content: " + myClass.getString() + " " + myClass.getInt1() + " " + myClass.getInt2() + " " + myClass.getInt3());
}