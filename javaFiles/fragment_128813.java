randomlyFillArray(array, 1, 1000);
long startTime = System.currentTimeMillis();
long total = 0;  // this thing is never used...
SelectionSort(array); // move this line between start time and end time!
long stopTime = System.currentTimeMillis();
long elapsedTime = stopTime - startTime;
System.out.println("SelectionSort for 500 integer :  " + elapsedTime);