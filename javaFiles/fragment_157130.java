// This also declares i at more restricted scope.
for (int i=0; i < values.length; ) { // <-- remove i increment.
    System.out.print("Enter a number between 70 and 90: ");
    int value = scanner.nextInt();
    if (value < 70 || value > 90) {
        continue; // <-- will not increment i. 
                  // because I removed the increment in the for loop.
                  // also could have done --i, then continue;
    }
    values[i] = value;
    sum += value; // <-- you can use += too
    i++; // <-- after adding to the sum.
}