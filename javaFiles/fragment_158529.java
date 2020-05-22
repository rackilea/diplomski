public class Bag {
    private String[] bag = new String[5];
    private int count = 0; //the new count here

    public void add(String bagToStore) {
        if (count < bag.length){
            bag[count] = bagToStore; //store the new bag in the current position
            count++; //then increment it
        }
    }

    //the remove has more logic because it has to shift the bags if it removes one, 
    //not to leave wholes in the array
    public void remove(String bagToRemove) {
        boolean found = false;
        for (int i=0;i < count; ++i){
            if (bag[i].equals(bagToRemove)){ //to compare Strings you must use equals
                found = true;
            }

            if (found && count < bag.length){
                bag[i] = bag[i+1];
            }
        }

        if (found) count--; 
    }

    void display() {
        for (int i = 0; i < count; ++i) //the display has to be done with a for 
            System.out.println("The contents are: " + bag[i]); 
    }
}