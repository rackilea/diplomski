public class SO_MinMaxArrayGroups {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, -3, 4, 5, 6, 17, 13, 14, 14, 14, 12, 1, 2, 2, 4, 3, 4,1, 2, 3, 4, 5, 6, 12, 13, -14, 14, 14, 12, 1, 2, 2, 4, 3, 4,1,4,7 };
        for (int i = 0; i < 3; i++) {
            int max = arr[13*i];
            int min = arr[13*i];
            for (int j = i * 13; j < (i + 1) * 13; j++) {
                //System.out.println("Checking :" + arr[j]);
                if (arr[j] > max) {
                    max = arr[j];
                }
                if (arr[j] < min) {
                    min = arr[j];
                }
            }
            System.out.println("Secion :"+(i+1)+"  Max : " + max + " Min : " + min);
        }
    }
}