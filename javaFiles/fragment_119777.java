public class Test {


 public void continueIf(){
    if(A[random]==1)
        A[random]=0;
    else {
        continueIf();
    }
 }

 public static void main(String[] args) {
    new Test().continueIf();
 }
}