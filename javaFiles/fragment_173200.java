int xLength = 10;
int[] charCount = new int[5];
charCount[0] = 10;
charCount[1] = 4;
charCount[2] = 7;
charCount[3] = 14;
charCount[4] = 1;

// determine the biggest value:
int biggest = 0;
for(int n:charCount) {
    if(n>biggest)
        biggest = n;
}
System.out.println("Biggest no: " + biggest);

double factor = (double)xLength / (double)biggest;
System.out.println("Using factor: " + factor);

for(int i = 0; i < charCount.length; i++) {
    System.out.print("no " + i + ":");
    for(int j = 0; j < charCount[i] * factor; j++) {
        System.out.print("*");
    }
    System.out.println();
}