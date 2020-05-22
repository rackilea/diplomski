public void AIMove(){
    Random randomInt = new Random ();

    boolean tryRemove =  true;

    while(tryRemove && totalSticks > 1){
        int RandomRow = randomInt.nextInt(3);
        if(Sticks[RandomRow] <= 0)//the computer can't remove from this row
            continue;

        //the max number to remove from row
        int size = 3;
        if( Sticks[RandomRow] < 3)//this row have lest that 3 cards
            size = Sticks[RandomROw];//make the max number to remove from the row be the number of cards on the row 
        int RandomDiscard = randomInt.nextInt(size) + 1;
        Sticks[RandomRow] = Sticks[RandomRow] - RandomDiscard;
        //I don't know if this is needed, but since we remove a RandomDiscard amount lest decrease the totalSticks
        totalSticks = totalSticks - RandomDiscard;
        //exit loop
        tryRemove = false;
    }

    if(totalSticks <= 1){
        Sticks[RandomRow]=Sticks[RandomRow]-1;
        isOver();
    }


}