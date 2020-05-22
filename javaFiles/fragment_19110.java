public class InitializeThetas {

    public static Collection<DoubleMatrix> InitializeThetas(DoubleMatrix sizes, double epsilon)
    {
        int L= sizes.length;
        epsilon = 0.03;
        Collection<DoubleMatrix> Thetas = new ArrayList<DoubleMatrix>();

        for (int i = 0; i < L - 1; i++)
        {
            Thetas.add(DoubleMatrix.rand(Double.valueOf(sizes.get(i + 1)).intValue(), Double.valueOf(sizes.get(i)).intValue() + 1).mul(2).mul(epsilon).sub(epsilon));
        }
        return Thetas;
    }

    public static void main(String[] args) {
        DoubleMatrix soze = new DoubleMatrix(10);
        for(int i = 0;i<10;i++){
            soze.put(i,i+1);
        }
        System.out.println(InitializeThetas(soze,1.1));
    }

}