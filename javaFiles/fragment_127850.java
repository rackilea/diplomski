public class Array2 {
    public int [][] twoDim = new int[4][];

    public Array2(){ // Constructor for Array2 class
        twoDim[0] = new int[]{1,2,3}; // Set the values
    }

    public static void main(String[] args){
        Array2 array2Instance = new Array2(); // Create an instance, calls constructor
        System.out.println(array2Instance.twoDim[0][1]); // Access the instance's array
    }
}