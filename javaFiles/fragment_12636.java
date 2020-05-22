for(int i = 0; i < myArray.length; i++)   
{   
    System.out.println(i + " - " + myArray[i]); 
    myArray[i] = myArray[i] * 2;
    System.out.println(i + " after multiplication - " + myArray[i]); 
}