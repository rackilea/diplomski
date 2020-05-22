public static void lambda(HashSet<Integer> s){
    if(end(s)){
        return;
    }
    ArrayList<Integer> diff = new ArrayList<Integer>();
    for(int i=0;i<w;i++){
        //an array version of the next set, it is pre-computed
        int[] a = get_next_set_array();
        for(int j=0;j<a.length;j++){
            if(!s.contains(a[j])){
               diff.add(a[j]);
            }
        }
        s.addAll(diff);
        do_stuff_to(s);
        s.removeAll(diff);
        diff.clear();
        lambda(p);
    }
}