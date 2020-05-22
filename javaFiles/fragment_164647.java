public static void main(String[] args) {
    double numbers []= {1.9,2.5,3.7,2,1.5,6,3,4,5,2};
    int index= indexOfLargestElement(numbers);
    System.out.println("The index of the largest number is: "+index);

}
public static int indexOfLargestElement(double[] array){
    int index=0;
    double largest=0;
    for (int i = 0; i < array.length; i++) {
        if (array[i]>largest){
            largest= array[i];
            index=i;
        }
    }
    return index;
}