int maxIndex = 10;
int numberOfChunks= 5;
int chunkSize =new Double( Math.floor( ((double)maxIndex) / numberOfChunks)).intValue();

int counter = 0;
for (int i = 0; i < numberOfChunks; i++) {
    int min = counter;
    int max = counter + chunkSize - 1;
    if (i == numberOfChunks - 1) {
        max = maxIndex;
    }
    counter += chunkSize;
    System.out.println(min + " - " + max);

}