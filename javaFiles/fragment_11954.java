int inputArray[] = {4, 6, 5, -10, 8, 1, 2};
int inputNumber = -8;

IntStream.range(0, inputArray.length-1).forEach(i -> IntStream.range(i+1, inputArray.length)
    .forEach(j -> {
        if (inputArray[i]+inputArray[j] == inputNumber) 
            System.out.println("Found "+inputNumber+"; a["+i+"]="+inputArray[i]+" a["+j+"]="+inputArray[j]);
        }));;