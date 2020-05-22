public void changeABFF()
{
    System.out.print("Enter a friend's name to be change: ");
    String name= keyboard.next().toLowerCase().trim();//entry name to be update
    Iterator<BestFriends> nameIter = myBFFs.iterator(); 
    while (nameIter.hasNext()){
        best = nameIter.next();
        if (best.getNickName().trim().toLowerCase().equals(name)){// if equals name
            best.setNickName("NEW DATE");//update data with new data Setters
            ....
        }           
    }
}