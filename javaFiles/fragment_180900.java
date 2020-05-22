public void shoes(int[] pairs)
{
    System.out.println("We will roll go through the boxes 100 times and store the input for the variables");
    int boxCount[] = new int[100];
    for(int i=0; i < boxCount.length; i++)
    {
        //("Random Number ["+ (i+1) + "] : " + (int)(Math.random()*6));
        boxCount[i]  =  (int) (Math.random()*6) + 1;
    }
}