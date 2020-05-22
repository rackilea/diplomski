List<Foo> items = new ArrayList<Foo>();
// add stuff to items (say, 6 things)

Map<String,List<Integer>> userOrders = new HashMap<String,List<Integer>>();
userOrders.put("A", Arrays.asList(0,1,2,3,4,5)); // add user A's order
userOrders.put("B", Arrays.asList(5,4,3,2,1,0)); // add user B's order

// display for userA:
for(Integer i : userOrders.get("A")){
    show(items.get(i)); // show the userA's i-th item
}