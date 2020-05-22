Map<String, MyClass> map = new HashMap<String, MyClass>();
// add some entries

List<Entry<String,MyClass>> entryList = 
     new ArrayList<Entry<String,MyClass>>(map.entrySet());
Collections.sort(entryList, new Comparator<Entry<String,MyClass>>() {
    public int compare(
        Entry<String, MyClass> first, Entry<String, MyClass> second) {
            return first.getValue().getFoo()
                        .compareTo(second.getValue().getFoo());
    }
});