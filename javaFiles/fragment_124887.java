public static void main(String[] args) {
    int[] array = {1,2,3,4,5,6,7,7,7,8};
    int[] result= findCount(array);
    for (int i=0; i<result.length; l++)
        System.out.print(result[i]+" ");

    System.out.println();
}

public static int[] findCount(int[] arr) {
     int[] result = new int[arr.length];
     for (int i=0; i<arr.length; i++){
         for (int j=0; j<arr.length; j++) {
             if (arr[i]==arr[j])
                 result[i]++;
         }
     }
     return result;
}