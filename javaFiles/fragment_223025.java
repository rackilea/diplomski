//Generate 10 random numbers between 1-100

  for(int i = 0; i < numbers.length; i++) {
    numbers[i] = (int)(Math.random() * 100 + 1);
    }//end of loop
bubblesort(numbers);
System.out.println("The unsorted list is: " + Arrays.toString(numbers));}