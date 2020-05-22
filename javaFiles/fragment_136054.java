public void intoArray()
{
    while(!carQueue.isEmpty())
    {
        int size = carQueue.size();
        for(int m = 0; m <= size ; m++)
        {side[m] = carQueue.poll();}
    }

}