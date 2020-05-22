System.out.printf("\n%1s%25s%20s%20s\n", "Method", "#COMP", "#ASGN", "#OPS");

resetCounts();
bubbleSort(Arrays.copyOf(numbers, numbers.length));
System.out.printf("%1s%25d%20d%20d\n", "Bubble", numComp, numAsgn, numAsgn + numComp);

resetCounts();
selectionSort(Arrays.copyOf(numbers, numbers.length));
System.out.printf("%1s%22d%20d%20d\n", "Selection", numComp, numAsgn, numAsgn + numComp);

resetCounts();
insertionSort(Arrays.copyOf(numbers, numbers.length));
System.out.printf("%1s%22d%20d%20d\n", "Insertion", numComp, numAsgn, numAsgn + numComp);

resetCounts();
shellSort(numbers);
System.out.printf("%1s%26d%20d%20d\n", "Shell", numComp, numAsgn, numAsgn + numComp);