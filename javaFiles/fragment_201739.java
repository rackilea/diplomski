public int getNextID (){
    for(int i = 0; i < members.size(); i++){
        if(i < members.get(i).getID()){
            System.out.println("Next available ID:  " + i);
            // at this point we know this is the next id.
            // we can leave the method and return the next ID.
            return i;
        }
    }
    // we did not leave the loop (and method), because all id's are assigned.
    System.out.println("Next available ID:  " + members.size());
    return members.size();
}