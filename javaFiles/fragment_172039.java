for(int i = 0; i < size; i++) {
    randomArray[i] += random.nextInt(101); //Populate the array
}
Arrays.sort(randomArray); // Sort the array
for(int i = 0; i < size; i++) {
    output.print(randomArray[i] + " "); // Write the array to the file
}