outterLoop: for(int i = 0; i < 10; i++)
{
    while(condition)
    {
        // some code

        if(someConditon) break outterLoop; // break the for-loop
        if(anotherConditon) break; // break the while-loop

        // another code
    }

    // more code
}