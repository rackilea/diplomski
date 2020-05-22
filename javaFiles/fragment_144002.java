public class Matrix {
    public static Kare[][] matrix = new Kare[3][3];
    //matrix is declared 'static' because it is one per application; 
    //you don't want different instances of Matrix, each one with its own  Kare[][] matrix

    //the equivalent of siram()
    public static void fillMatrix() {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                matrix[i][j] = new Kare(i,j);
    }

}

public class Sirala {
   public static void main(String[] args) {

        Matrix.fillMatrix();
        Matrix.matrix[1][2].setEsas(5);
        System.out.println(Matrix.matrix[1][2].getEsas());

        //because matrix field is static, i call it using class name, like Matrix.matrix
        //otherwise, i would have called it   new Matrix().matrix
    }
}