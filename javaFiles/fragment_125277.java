//Create the variable which will hold the last element in the array
int iMax = 0;
String arrayRec[] = new String[100];

arrayRec[0] = "FirstValue";
arrayRec[1] = "SecondValue";
arrayRec[2] = "ThirdValue";
arrayRec[3] = "FourthValue";
arrayRec[4] = "FifthValue";
arrayRec[5] = "SixthValue";
arrayRec[6] = "SeventhValue";
arrayRec[7] = "EigthValue";
arrayRec[8] = "NinthValue";
arrayRec[9] = "TenthValue";

//Run through each index in the array to see how many are filled
//All unfilled indexes will be pre filled with null values
for( String s : arrayRec )
{
    if( s != null ) //if the index does not contain null
    {
        iMax++; //Add another one to the counter
    }
}

System.out.println("Highest element in array = " + iMax); //iMax variable will return ten for the ten values