static void getMatrix(){
        int i,j;
        System.out.println("Enter size of matrix  || Enter m,n,p");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        p = sc.nextInt();
        a= new int [m][n];
        b = new int [n][p];

        System.out.println("Enter matrix A");
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter matrix B");
        for(i=0;i<n;i++){
            for(j=0;j<p;j++){
                b[i][j] = sc.nextInt();
            }
        }

    }