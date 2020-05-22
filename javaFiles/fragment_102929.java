class MySet<A> {
     ArrayList<A> contents = new ArrayList();
     HashMap<A,Integer> indices = new HashMap<A,Integer>();
     Random R = new Random();

     //selects random element in constant time
     A randomKey() {
         return contents.get(R.nextInt(contents.size()));
     }

     //adds new element in constant time
     void add(A a) {
         indices.put(a,contents.size());
         contents.add(a);
     }

     //removes element in constant time
     void remove(A a) {
         int index = indices.get(a);
         contents.set(index,contents.get(contents.size()-1));
         contents.remove(contents.size()-1);
         indices.set(contents.get(contents.size()-1),index);
         indices.remove(a);
     }
}