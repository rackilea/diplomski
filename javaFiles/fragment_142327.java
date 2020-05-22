ArrayList<Class<? extends A>> list = new ArrayList<Class<? extends A>>();
list.add(B.class);
list.add(A.class);


// get the value of first class stored in array
Field f = list.get(0).getDeclaredField("i");
Class<?> t = f.getType();
if (t == int.class) {
    System.out.println(f.getInt(null));
}