int a[] = {7,7,8,4,3,2,1,6,0,0};
Map<Integer, Integer> map = new HashMap<Integer, Integer>();

//0->5, 1->9, 2->8, 3->7, 4->6, 5->0, 6->4, 7->3, 8->2, 9->1
map.put(0, 5);
map.put(1, 9);
map.put(2, 8);
map.put(3, 7);
map.put(4, 6);
map.put(5, 0);
map.put(6, 4);
map.put(7, 3);
map.put(8, 2);
map.put(9, 1);

for (int i = 0; i < a.length; i++) {
    a[i] = map.get(a[i]);
}