public class Main {

    static int a[] = {1,2,3,4,5,6,0,0,0,0};

    public static void main(String args[]){

        for(int i=0; i<a.length; i++){
            if(a[i]!=0)
                System.out.print(a[i]+"*");    

        }
    }
}