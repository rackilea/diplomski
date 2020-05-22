public class MyProgram9{
 public static void main(String[] args){

    int[] list = new int[10];
    for (int i=0; i<10; i++){
        int n = (int)(Math.random()*9 + 1);
        list[i] = n;

        System.out.println(list[i] + " ");
    }
    QuickSort.quicksort(list);
 }
}