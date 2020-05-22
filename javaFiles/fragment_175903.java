package p1;
public class Matrix {

    public Matrix(int b,Vector...vectors) {

        double myArray[][] = new double[vectors.length][];
        int row = vectors.length;

        int column = vectors.length;
        for (int i = 0; i < row; i++) {
            myArray[i] = new double[column];
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(b==0) {
                    myArray[i][j] = vectors[i].getYourArray()[j]; // change made here
                } else {
                    myArray[j][i] = vectors[i].getYourArray()[j]; // change made here
                }
            }
        }
    }
}