public class Matrix
{
    private double[][] matrixData;

    private int col;

    private int row;

    /**
     * Create matrix of zero size
     */
    public Matrix()
    {
        this(0);
    }

    public Matrix(double[][] matrixData)
    {
        this.matrixData = matrixData;

        this.row = matrixData.length;
        this.col = matrixData[0].length;
    }

    public Matrix(double[] matrixData)
    {
        this.row = matrixData.length;
        for (int i = 0, size = matrixData.length; i < size; i++)
        {
            this.matrixData[0][i] = matrixData[i];
        }
    }

    public Matrix(int size)
    {
        this.matrixData = new double[size][size];
        this.col = size;
        this.row = size;
    }

    public Matrix(int row, int col)
    {
        matrixData = new double[row][col];
        this.row = row;
        this.col = col;
    }

    /**
     * Static method which creates a matrix with a single column.
     * 
     * @param input
     * @return
     */
    public static Matrix createColumnMatrix(final double input[])
    {
        double result[][] = new double[input.length][1];
        for (int i = 0; i < input.length; i++)
            result[i][0] = input[i];

        return new Matrix(result);
    }

    /**
     * Static method which creates a matrix with a single row.
     * 
     * @param input
     * @return
     */
    public static Matrix createRowMatrix(final double input[])
    {
        double result[][] = new double[1][input.length];
        for (int i = 0, size = input.length; i < size; i++)
            result[0][i] = input[i];

        return new Matrix(result);
    }

    /**
     * Convert the matrix into a one dimentional matrix
     * 
     * @return
     */
    public double[] toPackedArray()
    {
        int size = row * col;
        int index = 0;
        double[] results = new double[size];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                results[index++] = matrixData[i][j];

        return results;
    }

    /**
     * Adds the specified value to given cell in the matrix.
     * 
     * @param row
     * @param col
     * @param value
     */
    public void add(final int row, final int col, final double value)
    {
        matrixData[row][col] += value;
    }

    /**
     * Sets every cell in a matrix to zero.
     */
    public void clear()
    {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matrixData[i][j] = 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return new Matrix(matrixData);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Matrix))
        {
            return false;
        }
        Matrix that = (Matrix)obj;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
            {
                if (matrixData[i][j] != that.get(i,j))
                    return false;
            }

        return true;
    }

    public void print()
    {
        for (int i = 0; i < matrixData.length; i++)
        {
            for (int j = 0; j < matrixData[i].length; j++)
            {
                System.out.print(matrixData[i][j] + ", ");
            }
            System.out.println();
        }
    }

    /**
     * Gets one column of a matrix object as a new matrix object.
     * 
     * @param col
     * @return
     */
    public Matrix getCol(final int col)
    {
        double[] results = new double[matrixData[col].length];
        for (int i = 0; i < row; i++)
            results[i] = matrixData[i][col];

        return Matrix.createColumnMatrix(results);
    }

    /**
     * Gets one row of a matrix object as a new matrix object.
     * 
     * @param row
     * @return
     */
    public Matrix getRow(final int row)
    {
        double[] results = new double[this.row];
        for (int i = 0; i < col; i++)
            results[i] = matrixData[row][i];

        return Matrix.createRowMatrix(results);
    }

    /**
     * Returns the sum of every cell in a matrix object.
     * 
     * @return
     */
    public double sum()
    {
        double total = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
            {
                total += matrixData[i][j];
            }
        return total;
    }

    /**
     * Determines if every cell in a matrix object is zero.
     * 
     * @return
     */
    public boolean isZero()
    {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
            {
                if (matrixData[i][j] != 0)
                    return false;
            }

        return true;
    }

    /**
     * Get given value at a specific location
     * 
     * @param row
     * @param col
     * @return
     */
    public double get(int row, int col)
    {
        return matrixData[row][col];
    }

    public int getCols()
    {
        return col;
    }

    public int getRows()
    {
        return row;
    }

    public static Matrix identity(final int size)
    {
        final Matrix result = new Matrix(size,size);

        for (int i = 0; i < size; i++)
        {
            result.set(i,i,1);
        }
        return result;
    }

    /**
     * Set given row and column using 0 based indexes
     * 
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value)
    {
        matrixData[row][col] = value;
    }

    /**
     * Get the copy of the current matrix
     * 
     * @return
     */
    public double[][] getRawMatrix()
    {
        double[][] copy = new double[matrixData.length][];
        for (int i = 0; i < matrixData.length; i++)
        {
            copy[i] = new double[matrixData[i].length];
            for (int j = 0; j < matrixData[i].length; j++)
                copy[i][j] = matrixData[i][j];
        }
        return copy;
    }

    public static void dump(double[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
        }
    }

    public void dump()
    {
        dump(System.out);
    }

    public void dump(PrintStream ps)
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                ps.print(matrixData[i][j] + ", ");
            }
            ps.println();
        }
        ps.println();
    }

    public void add(Matrix contribution)
    {
        // TODO Auto-generated method stub

    }