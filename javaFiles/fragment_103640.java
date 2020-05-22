class abc{
static int n;
static int[] arr;
static void init(int size) {
    arr=new int[size];
}
static void print_arr(){
    for(int x: arr) System.out.print(x+" ");
} }


class Main {
public static void main(String[] args) {
    abc.n=5;
    init(abc.n);
    for(int i=0;i<abc.n;i++){
        abc.arr[i]=10;
    }
    abc.print_arr();
} }