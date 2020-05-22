private static class Coordinates
    {

        private int x = 0;
        private int y = 0;
        private int data = 0;

        public Coordinates(final int x, final int y)
        {
            this.x = x;
            this.y = y;
            data = ((x + "") + (y + "")).hashCode();
        }

        @Override
        public boolean equals(final Object obj)
        {
            if (obj instanceof Coordinates)
            {
                Coordinates Coordinates = (Coordinates) obj;
                return ((x == Coordinates.x) && (y == Coordinates.y));
            }
            else
            {
                return false;
            }
        }

        @Override
        public int hashCode()
        {
            return data;
        }
    }

    private int numrows;
    private int numcolumns;
    private HashMap<Coordinates, Double> theMatrix;

    public Matrix(final int numrows, final int numcolumns)
    {
        this.numrows = numrows;
        this.numcolumns = numcolumns;
    }

    public Matrix(HashMap<Coordinates, Double> matrixdata)
    {
        theMatrix = new HashMap<Coordinates, Double>(matrixdata);
    }

    public Double get(int row, int col, double defaultValue)
    {
        Double ret = theMatrix.get(new Coordinates(row, col));
        return ret != null ? ret : defaultValue;
    }

    public void set(int row, int col, Double value)
    {
        theMatrix.put(new Coordinates(row, col),  value);
    }
}