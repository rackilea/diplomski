public void generateNewSecret()
    {
    Random rand = new Random();{
secretNumber =  new int[numDigitsSet];
    for (int i=0; i<numDigitsSet; i++)
    {
        secretNumber[i]= rand.nextInt(10);

            }
        }
    }