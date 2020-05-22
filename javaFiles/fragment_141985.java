public class NewClass56 {
public static void main(String args[]){

    int a[] = new int[] {84 ,81 ,41 ,79 ,17 ,38 ,33 ,15 ,61 ,6};

    for(int i=0;i<10;i++){
        for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<10;j++){
            System.out.print(a[j+(int)Math.pow(2,i)-1]+" ");

        }
        System.out.println();
    }



    }
}