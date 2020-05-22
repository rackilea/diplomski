randomlyFillArray(array, 1, 1000);
SelectionSort(array);
long startTime = System.currentTimeMillis();
long total = 0;
long stopTime = System.currentTimeMillis();
long elapsedTime = stopTime - startTime;
SelectionSort(array);
System.out.println("SelectionSort for 500 integer :  " + elapsedTime);