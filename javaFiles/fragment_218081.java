ArrayList<Double> myArray = new ArrayList<Double>();
if (boolA) myArray.add(doubleValueA);
if (boolB) myArray.add(doubleValueB);
// etc

double minValue = Double.MAX_VALUE; // start with largest possible value
// loop through and replace with any smaller values
for (double val : myArray)
    if (val < minValue) minValue = val;
// val now contains the smallest value