if(inputFile != null) {
    // the number of integers we've read so far
    int count = 0;

    // loop through file for integers and store in array
    while(inputFile.hasNextLine()) {
        for(int i = 0; i < array.length; i++) {
            try {
                array[count] = inputFile.nextInt();
                count++;
            } catch(InputMismatchException excep1) {
                String word = inputFile.next();
            } catch(NoSuchElementException excep2) {
            }
         }
     }
}