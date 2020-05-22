public class OneIndexed2DArray {
        int[][] indexedArray;

        public OneIndexed2DArray(int row, int col)
        {
            indexedArray = new int[row + 1][col + 1];
        }

        public int GetValue(int row, int col) throws ArrayIndexOutOfBoundsException
        {
            if(row == 0 || col == 0)
            {
                throw new ArrayIndexOutOfBoundsException();
            }
            else
                return indexedArray[row][col];
        }

        public void SetValue(int row, int col, int value) throws ArrayIndexOutOfBoundsException
        {
            if(row == 0 || col == 0)
            {
                throw new ArrayIndexOutOfBoundsException();
            }
            else
                indexedArray[row][col] = value;
        }
    }