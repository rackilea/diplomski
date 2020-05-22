List<B> list1 = ..;
List<A> list2 = list1;
list2.add(new C());
for (B b : list1) {
    //ClassCastException - cannot cast from C to B
}