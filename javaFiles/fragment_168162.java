public void listMatching(String searchString) {
    boolean match = false; // initialize local variable
    for(String filename : files) {
        if(filename.contains(searchString)) {
            System.out.println(filename);
            match = true;
        }
    }
    if(!match) { // same as 'match == false', just without comparison
        System.out.println("No matches found for " + searchString);
    }
}