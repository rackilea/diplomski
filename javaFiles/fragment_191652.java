public class SugarBowl {
    private int totalCapacity;
    private int availableSpace;
    private int spoonSize;
    private int occupiedSpace;//starts at 0, because there's nothing in the bowl.

    /**
     * Constructor for the sugar bowl.
     * @param totalCapacity     The total capacity of the bowl.
     */
    public SugarBowl (int totalCapacity){
        this.totalCapacity = totalCapacity; //set the totalCapacity for the bowl
        availableSpace=totalCapacity;
        spoonSize = totalCapacity/20;//arbitrary size
        occupiedSpace = 0;
    }
    /**
     * Shows how much sugar can fit in a spoon.
     * @return  The size of the spoon
     */
    public int spoon(){
        return spoonSize;
    }
    /**
     * Returns amount of sugar in the bowl.
     * @return  The amount of occupied space
     */
    public int occupied(){
        return occupiedSpace;
    }
    /**
     * Removes the amount of sugar based on the
     * number of scoops passed into it.
     * @param numberOfScoops    The number of scoops
     * @return          The amount of sugar removed
     */
    public int scoops (int numberOfScoops){

        int possibleAmountTaken = numberOfScoops * spoonSize;
        int actualAmountTaken = 0;
        //Think about sugar, even if there is less sugar than the spoon size, 
        //can a spoon still remove that amount?
        //aka the only time 0 sugar should be taken is when there is 0 sugar in the bowl
        if (possibleAmountTaken<=occupiedSpace){
            actualAmountTaken = possibleAmountTaken;
        }
        else{
            //there may still be sugar, just not enough for every scoop, you still have to remove it
            //actualAmountTaken = ???
        }
        occupiedSpace = occupiedSpace - actualAmountTaken;
        //what about availableSpace?
        //availableSpace = ???
        return actualAmountTaken;       
    }
    /**
     * Adds the specified amount of sugar to the bowl.
     * 
     * @param addedAmount   The amount of sugar added to the bowl
     * @return  The overflow amount of sugar or 0 if there was no overflow
     */
    public int addSugar (int addedAmount){
        int overflow = 0;
        if (addedAmount>availableSpace){
            overflow = addedAmount-availableSpace;
            //your bowl is going to be full, what happens to occupiedSpace and availableSpace?
            //availableSpace = ???
            //occupiedSpace = ???
        }
        else{
            //overflow is already 0 so you don't have to do anything with it
            //update availableSpace and occupiedSpace
            //availableSpace = ???
            //occupiedSpace = ???
        }
        return overflow;
    }
}