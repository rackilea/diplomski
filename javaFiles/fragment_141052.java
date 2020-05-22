public boolean addFruit(String fruitName,int type, int numItems, int itemWeight) {
    if (!toCapacity()){
        // change to match your constructor
        Fruit other = new Fruit(fruitName, type, numItems, itemWeight);    
        if (isCompatibleWith(other)){
            //Implement your logic to 'add' the fruit somewhere
            return true;
        }else{
            System.out.println("Cannot add fruit, incompatible with other fruits."); 
        }    
    }else{
         System.out.println("Cannot add fruit, cart is full.");
    }
    return false;
}