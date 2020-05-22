public CompetitionGround(int boundries)
{
    //Remember, you want IEgg, not Egg here
    //This is so that you can add elements that implement IEgg but aren't Eggs
    eggs = new IEgg[boundries][boundries];

    for (int i = 0; i <boundries; i++)
    {
        for (int j = 0; j <boundries; j++)
        {
            eggs[i][j]=new Egg();
        }
    }
}