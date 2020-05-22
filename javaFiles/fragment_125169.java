List<MyObject> list = new ArrayList<>();
list.add(new MyObject("AAA", 1, 0));
list.add(new MyObject("CCC", 3, 0));
list.add(new MyObject("AAA", 1, 0));
list.add(new MyObject("BBB", 2, 0));
list.add(new MyObject("AAA", 1, 0));

Map<Integer, MyObject> temp = new HashMap<>();
list.forEach( x -> {
    MyObject o = temp.get(x.id);
   if (o == null) {
        temp.put(x.id, x);
        x.quantity = 1;
    } else {
        o.quantity++;
    }
});
List<MyObject> result = new ArrayList<>(temp.values());