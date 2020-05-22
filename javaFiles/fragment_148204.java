import java.util.Random;

    class Matrix 
    { 
        double[][] arrayA;

        public Matrix(double[][] array) //Create matrix values
        {
            arrayA=array;
        }

        public Matrix(int rows, int columns) //Create matrix values
        {
            double[][]array= new double[rows][columns];
            Random rand = new Random();

            for(int i = 0; i < array.length; i++)
            {
                for(int j = 0; j < array[i].length; j++)
                {
                    array[i][j] = rand.nextInt(10);
                }
            }
            arrayA=array;
        }

        public Matrix multiply(Matrix m)
        {
            double[][]b=m.arrayA;
            double[][] c = new double[arrayA.length][b[0].length];

            for(int i = 0; i < arrayA.length; i++)
            {
                for(int j = 0; j < b[0].length; j++)
                {
                    for(int k = 0; k < arrayA[0].length; k++)
                    {
                        c[i][j] += arrayA[i][k] * b[k][j];
                    }
                }
            }

            return new Matrix(c);
        }


        public void print(){
            for(int i=0;i<arrayA.length;i++){
                for(int j=0;j<arrayA[0].length;j++){
                    System.out.print(arrayA[i][j] + " | ");
                }
                System.out.println();
            }
        }
    }