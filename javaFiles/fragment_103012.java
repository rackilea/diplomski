public void processTransactions(Scanner transFile){

    while (transFile.hasNext()){
       String key = transFile.next();
       int value = transFile.nextInt();
       for(i = 0; i < ids.length; i++){
           finalInventory[i] = startingInventory[i];

           if(ids[i].equals(key)){
               finalInventory[i] += value;
            }
        }
    }
}