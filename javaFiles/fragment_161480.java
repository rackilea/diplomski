public void removeABFF()
{
    System.out.print("Enter a friend's name to be removed: ");
    String name= keyboard.next().toLowerCase();// entry name to be removed
    Iterator<BestFriends> nameIter = myBFFs.iterator(); //manipulate ArrayList
    while (nameIter.hasNext()){
        best = nameIter.next(); // obtained object list
        if (best.getNickName().trim().toLowerCase().equals(name)){ // if equals name
            nameIter.remove(best); // remove to arraylist
        }           
    }    
}