// Collection of items to process in parallel
Collection<Integer> elems = new LinkedList<Integer>();
for (int i = 0; i < 40; ++i) {
    elems.add(i);
}
Parallel.For(elems, 
 // The operation to perform with each item
 new Parallel.Operation<Integer>() {
    public void perform(Integer param) {
        System.out.println(param);
    };
});