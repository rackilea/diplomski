public void read() {
        Scanner citast = new Scanner(System.in);
        System.out.println("How many arrays do you want to enter?");
        x=citast.nextInt();
        this.mat = new double[x][][]; //<-- added this line
        for (this.l=0; this.l<x; this.l++)
        {
            System.out.println("Matrix "+this.l);
            System.out.println("Number of lines: ");
            this.a = citast.nextInt();
            System.out.println("Number of columns: ");
            this.b = citast.nextInt();
            this.mat[l] =  new double [a][b]; //<-- modified this line
            for (int i=0; i<this.a; i++)
                for (int j=0; j<this.b; j++)
                {
                    System.out.print("Matrice " + l + " ["+ i +"]["+ j +"]= ");
                    this.mat[l][i][j]=citast.nextInt();
                }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(mat));
    }