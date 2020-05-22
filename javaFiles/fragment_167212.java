// using comparator
SortedSet<ClassA> set = new TreeSet<>( new Comparator() {
    @Override
    public int compare(ClassA a, ClassA b) {
        // your implementation 
    }
});

// java 8 lambda
SortedSet<ClassA> set = new TreeSet<>( (a, b) -> {
   // your implementation
});