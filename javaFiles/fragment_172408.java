double minVal = Double.MAX_VALUE;
int minIndex = -1;
for (int i=0, max=distances.length; i<max;i++) {
    if (values[i] < minVal) {
        minVal = values[i];
        minIndex = i;
    }
}
System.out.println("The Nearest to point 1 is point: "+minIndex+" with value "+minVal);