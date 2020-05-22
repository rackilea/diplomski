static double[][] matrixMult(double[][] A,double[][] B) {
        double[][] C = new double[A.length][B.length]; //declar this variable for return the result
        //return null if on of matrix are null
        if(A == null || B == null){
            return null;
        }


        if(A[1].length == B.length){ //check to be equal columns of A with rows of B
            for(int n = 0;n < A.length;n++){//n is numbers of rows of A
                for(int k = 0;k < B[n].length;k++){
                    C[n][k] = 0.0;
                     for(int l = 0;l < A[n].length;l++){//row n of A multiple in column k of B
                        C[n][k] += A[n][l] * B[l][k];

                    }
                }

            }
        return C;
        } else {
        return null;
        }

    }


    static double[][] matrixAdd(double[][] a,double[][] b) {

    double[][] d = new double[a.length][b.length]; //declar this variable for return the result
    //check the rows and columns of a and b are equal
        if(a.length == b.length && a[1].length == b[1].length){
            for(int n = 0;n < b.length;n++){
                for(int m = 0;m < b[1].length;m++){
                    d[n][m] = a[n][m] + b[n][m];
                }
            }
            return d;
        }else {
            return null;
        }

    } 


    static void matrixDisplay(double[][] a){

        for(int i = 0; i < a.length;i++){
            for(int k = 0;k < a[1].length;k++){
                System.out.print(a[i][k] + "\t");
            }
        System.out.println();
        }

    }

public static void main(String[] args){
    double[][] A = {{1,2,3},{4,5,6}}; 

    double[][] B= {{1,2},{3,4},{5,6}};

    double[][] d;
    d = matrixMult(A,B);
    matrixDisplay(d);
}

}