public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> inner = new ArrayList<Integer>();        

    inner.add(100);     
    inner.add(200);
    outer.add(inner); // add first list
    inner = new ArrayList<Integer>(inner); // create a new inner list that has the same content as  
                                           // the original inner list
    outer.add(inner); // add second list

    outer.get(0).add(300); // changes only the first inner list

    System.out.println(outer);
}