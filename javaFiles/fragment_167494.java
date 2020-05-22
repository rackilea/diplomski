import java.util.*;
import static java.lang.System.out;
public class test{
    public static void main(String s[]){
        int array1[] = {1,3,-5,4,2,-8};
        int array2[] = {2,4,7,8,-9};
        int array3[] = {1,2,3,-4,6};
        int count = 0;
        boolean flag = false;
        for(int i=0;i<array1.length;i++){
            int temp;
            count++;
            if(array1[i]%2==0){
                for(int j=0;j<array2.length;j++){
                    if(array2[j]%2==1){
                        temp = array2[j];
                        array2[j] = array1[i];
                        array1[i] = temp;
                        break;
                    }
                }
            }
        }

            for(int i=0;i<array1.length;i++){
                int temp;
                if(array1[i]%2==0){
                    for(int j=0;j<array3.length;j++){
                        if(array3[j]%2==1){
                            temp = array3[j];
                            array3[j] = array1[i];
                            array1[i] = temp;
                            break;
                        }
                    }
                }
            }

        System.out.println("Array1");
        for(int i=0;i<array1.length;i++){
            System.out.println(array1[i]);
        }
        System.out.println("Array2");
        for(int i=0;i<array2.length;i++){
            System.out.println(array2[i]);
        }
        System.out.println("Array3");
        for(int i=0;i<array3.length;i++){
            System.out.println(array3[i]);
        }
    }
}