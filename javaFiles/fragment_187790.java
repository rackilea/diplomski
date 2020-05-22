public class M1test {
public static void main(String args[]){
    Matrix A= new Matrix(new double[][]{{2.0,3.0,5.0},{1.0,0.0,3.0},{0.0,1.0,1.0}});
    A.print(9,6);
    Matrix A1= new Matrix(new double[][]{{1.0,2.0,2.0}});
    A.setMatrix(2,2,0,2,A1);
    A.print(9,6);
}