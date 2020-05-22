double delta = 0.05; // or any other reasonable value
double[] expectedArray = 
    expectedList.stream().mapToDouble(Double::doubleValue).toArray();
double[] actualArray = 
    actualList.stream().mapToDouble(Double::doubleValue).toArray();
assertArrayEqulas(expectedArray, actualArray, delta);