import java.util.*;

class MultiArray<T>{
    private int[] dimensions;
    private Object[] array;

    public MultiArray(int ... dimensions){
        this.dimensions=dimensions;
        //Utils.product returns the product of the ints in an array
        array=new Object[Utils.product(dimensions)];
    }

    public void set(T value, int ... coords){
        int pos=computePos(coords); 
        array[pos]=value;
    }

    public T get(int ... coords){
        int pos=computePos(coords);
        return (T)(array[pos]);
    }

    private int computePos(int[] coords){
        int pos=0;
        int factor=1;
        for (int i=0;i<coords.length;i++){
            pos+=factor*coords[i];
            factor*=dimensions[i];
        }
        return pos;
    }
}

class Main{
    public static void main(String args[]){
        MultiArray<Integer> m=new MultiArray<Integer>(new int[]{5,4,3}); 
        Random r=new Random();

        for(int i=0;i<5;i++)
            for(int j=0;j<4;j++)
                for(int k=0;k<3;k++)
                    m.set(r.nextInt(),i,j,k);
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<3;k++)
                    System.out.print(m.get(i,j,k)+" ");     
                System.out.println("");
            }
            System.out.println("\n");
        }
    }
}

class Utils{
    public static int product(int...a){
        int ret=1;
        for (int x:a) ret*=x;
        return ret;
    } 
}