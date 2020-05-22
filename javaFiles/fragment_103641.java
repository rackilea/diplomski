class ABC{
 private int size;
 private int[] arr;

ABC(int n) {
    size = n;
    arr = new int[n];
}   

public void print_arr(){
    for(int x: arr) 
    System.out.print(x+" ");
}

public int getSize() {
    return size;
}

public int[] getArray() {
    return java.util.Arrays.copyOf(arr,arr.length);
}

public void setArray(int [] array) {
    arr = array.clone();
} }


class Main {
public static void main(String[] args) {

    int size = 5;
    ABC abc = new ABC(size);

    int [] array = new int[size];

    for(int i=0;i<abc.getSize();i++){
        array[i]=10;
    }
    abc.setArray(array);

    abc.print_arr();
} }