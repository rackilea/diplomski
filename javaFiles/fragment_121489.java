Scanner scanIn = new Scanner(System.in);

do{
    int n = scanIn.nextInt();
} while (n<1);

int number[] = new int[n];   

for(int i=0;i<n;i++) number[i] = scanIn.nextInt();

scanIn.close();