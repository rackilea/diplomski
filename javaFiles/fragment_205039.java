int number;
try
{
     number = Integer.parseInt (/*get string input here*/);
}
catch (NumberFormatException e)
{
     //error handling here
}

int array [] =  new int [2];
array[0] = number;