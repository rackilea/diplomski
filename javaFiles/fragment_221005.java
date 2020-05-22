Random random = new Random();
int [] array = new int[100000];

for (int i = 0; i < array.length; i++) {
  array[i] = random.nextInt(1000);
}

//Begin timer
long startTime = System.nanoTime();

for (int i = 0; i < array.length; i++) {
  int min = i;
  for (int j = i + 1; j < array.length; j++) {
    if (array[j] < array[min]) {
      min = j;
    }
  }
  if (min != i) {
    int temp = array[i];
    array[i] = array[min];
    array[min] = temp;
  }
}

//End timer
long endTime = System.nanoTime();

long timeDiff = (endTime - startTime);
double duration = (timeDiff/1000000.0);

System.out.println("Duration of sort (nanoseconds):");
System.out.println(timeDiff);
System.out.println("Duration of sort (milliseconds):");
System.out.printf("%.6f", duration);