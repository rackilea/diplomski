public static void main(String[] args)
{
    double arr[] = new double[]{
            86.0,
            12.0,
            55.0,
            90.0,
            77.0,
            22.0,
            25.0,
            33.0,
            45.0,
            20.0,
            23.0
    };// The array with which the value of file Text_1 compare
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    Scanner t1 = new Scanner(TestJama.class.getResourceAsStream("/Text_1.txt"));
    Scanner t2 = new Scanner(TestJama.class.getResourceAsStream("/Text_2.txt"));
    while (t1.hasNext())
    {
        double t1_id    = t1.nextDouble();
        double t1_col2    = t1.nextDouble();
        double t1_col3    = t1.nextDouble();
        Matrix t1_matrix = new Matrix(new double[][]{
                {t1_id},
                {t1_col2},
                {t1_col3}
        });

        //read the same row from Text_2.txt
        double t2_col1 = t2.nextDouble();
        double t2_col2 = t2.nextDouble();
        double t2_col3 = t2.nextDouble();

        double index = Arrays.binarySearch(
                arr,
                t1_id
        );
        if (index>0){
            Matrix t2_matrix = new Matrix(new double[][]{
                    {t2_col1},
                    {t2_col2},
                    {t2_col3}
            });
            System.out.print("Text_1 matrix(before add)");
            t1_matrix.print(9,6);
            System.out.print("Text_1 matrix(after add)");
            t1_matrix.plus(t2_matrix).print(9,6);
            System.out.println("=============================================================");
        }

    }
}