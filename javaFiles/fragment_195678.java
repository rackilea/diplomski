double gainT[]={54.3, 57.0, 62.5, 67.6, 74.3, 79.2, 80.9, 80.4, 77.8, 70.1, 62.8, 56.3};

double gainTC[] = new double[gainT.length]; //create array which matches the size of gainT
//array.length is a property value returning the 'size' or length or the array

//Now just iterate through all the gainT[] values you populated above and read each one
for(int i = 0; i < gainT.length; i++){
     double math = //use your conversion math here, and store the value
     gainTC[i] = math; //assign the results of your math to the same spot in the new array
}