String [] tempTrailerArr =  {"12.0 1.1", "24.51", "34.12", "82.87 231.2 1.1 2.2"};

String [] tempTrailerVals = null;
double[] trailerVals = new double [tempTrailerArr.length];

for (int i = 0 ; i < tempTrailerArr.length ; i ++)
{
    tempTrailerVals = tempTrailerArr[i].split(" ");
    // you should also add some error handling here - what if we can't convert the value to a double?
    trailerVals[i] = Double.parseDouble(tempTrailerVals[0]);

}