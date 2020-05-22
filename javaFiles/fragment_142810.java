public class Arraymini {

public static void main(String [] args){
    int [] testArray1= {1,6,3,9,2};
    double [] testArray2= {2.3, 8.66, 6.5, -9.2};
    printArray(testArray1);
    printArray(testArray2);
}

public static void printArray(int []k){
    for(int i=0; i<k.length; i++){
    System.out.println(k[i]+" ");
    }
}

public static void printArray(double[]g){
    for(int i=0; i<g.length; i++){
        System.out.println(g[i]+" ");
    }
}

}