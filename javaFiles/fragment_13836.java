// this uses an anonymous Comparator class but you can define a class to do it
Collections.sort(wrappers, new Comparator<ValueWrapper>() {
     public int compare(ValueWrapper o1, ValueWrapper o2) {
         return o1.value2.compareTo(o2.value2);
     }
});