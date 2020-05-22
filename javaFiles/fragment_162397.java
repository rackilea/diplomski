public ArrayList<String> searchName(String sn){ 

    ArrayList<String> searches = new ArrayList<>();

    //1. First add all the matches to the `searches` List.
    for(String n : names){ 
        if(n.contains(sn)){
            searches.add(n);
        }
    }

    //2. Now if the `searches` list is NOT empty, it means that 
    //   there were some matches, then display those matches
    if(!searches.isEmpty()) {
        displaySearches(searches);
    } else {
        //3. Otherwise print that there wasn't any match.
        System.out.println("No results for " + sn);
    }

    return searches;
}

public void displaySearches(ArrayList<String> searches){
    for(String s: searches){
        System.out.println(s);
    }
}