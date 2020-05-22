public static void main(String[] args) {
    int[] array = {10,7,11,5,13,8};
    exchangeSort(array);
    System.out.println("Sorted Array: "+Arrays.toString(array));
}
public static void exchangeSort(int[] num) {
    int temp;
    for(int i=0;i<num.length-1;i++){
        for(int j=i+1;j<num.length;j++){
            if(num[i]<num[j]){
                temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
    }
    System.out.println("Sorted Array: "+Arrays.toString(num));
}