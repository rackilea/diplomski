public class Selection {

    public static void sort(int[] array) {

        int min, temp;

        for (int i = 0; i <= array.length-1  ; i++) {
            min = i;
            for (int j = i+1; j <= array.length-1   ; j++) {
                if (  array[j]<array[min]) {
                    min = j;
                }

            }
            temp = array[min];
            array[min]=array[i];
            array[i] = temp;

        }
    }

    public static void main(String[] args) {
        int a[]  = {51,6,3,55,34,12 };
        sort(a);
        for (int i=0;i<a.length ;i++) {
            System.out.println(a[i]);
        }
    }

}