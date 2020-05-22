ArrayList<ChildClass> a3 = new ArrayList<>();
foo(a3);
ChildClass c = a3.get(0);

...

static void foo(ArrayList<Parent> obj) {
   obj.add(new Parent());
}