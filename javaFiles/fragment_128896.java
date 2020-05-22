outterLoop: for(int i = 0; i < 10; i++)
{
    while(condition)
    {
        // some code

        if(someConditon) continue outterLoop; // go to the next iteration of the for-loop
        if(anotherConditon) continue; // go to the next iteration of the while-loop

        // another code
    }

    // more code
}