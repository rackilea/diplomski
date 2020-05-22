int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;
int minIndex = 0;
int maxIndex = 0;

for (int i = 0; i < data.length; i ++) {
    System.out.println("Week "+(i+1)+" total sales:"+data[i]);
    System.out.printf("Average daily sales week "+(i+1)+": %.2f\n\n", data[i]/7);
    total += data[i];

    if (max < data[i]) {
        maxIndex = i;
        max = data[i];
    }
    if (min > data[i]) {
        minIndex = i;
        min = data[i];
    }
}