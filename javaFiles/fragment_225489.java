public static void main(String[] args){        
    //Initialize stuff
    ArrayList<Integer> dom_strat = new ArrayList<>();
    ArrayList<ArrayList<Integer>> dom_list = new ArrayList<>();
    dom_strat.add(5);
    dom_strat.add(3);

    //Add arrayList
    dom_list.add(dom_strat);

    //Print
    System.out.println("Before clear");
    for(ArrayList<Integer> aList:dom_list){
        for(Integer i: aList){
            System.out.println(i);
        }
    }
    //Clear referenced arrayList dom_list
    dom_strat.clear();
    //Print
    System.out.println("After clear");
    for(ArrayList<Integer> aList:dom_list){
        for(Integer i: aList){
            System.out.println(i);
        }
    }


     //Initialize again and apply the fix
    dom_strat = new ArrayList<>();
    dom_list = new ArrayList<>();
    dom_strat.add(5);
    dom_strat.add(3);

    //Add arrayList 
    dom_list.add(dom_strat);

    //Instead of clear, create a new arrayList
     dom_strat = new ArrayList<>();

     //Print
    System.out.println("After applying the fix");
    for(ArrayList<Integer> aList:dom_list){
        for(Integer i: aList){
            System.out.println(i);
        }
    }
}