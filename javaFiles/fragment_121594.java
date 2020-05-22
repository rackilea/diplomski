Types[] arr = Types.values();
Arrays.sort(arr, new Comparator<Types>() {
     @Override
     public int compare(Types o1, Types o2) {
         return o1.name().compareTo(o2.name());
     }
});
// arr is now [Age, Day, Hello, Night, Sum]