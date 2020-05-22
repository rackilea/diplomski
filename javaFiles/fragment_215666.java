ArrayList<Integer> toRemove=new ArrayList<>();//use diamond operator to reduce verbosity 
toRemove.add(7);
toRemove.add(8);
toRemove.add(9);
toRemove.add(13);
toRemove.add(22);
toRemove.add(55);
toRemove.add(88);
ArrayList<Integer> al=new ArrayList<>();
for(int i=0;i<100;i++){
    al.add(i);
}
al.removeAll(toRemove);