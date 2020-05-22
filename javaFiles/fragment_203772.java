class Sort2D
        {
            public static void main(String args[])throws IOException
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

                System.out.print("Enter the no. of  rows: "); //inputting number of rows
                int m=Integer.parseInt(br.readLine());
                System.out.print("Enter the no. of columns: "); //inputting number of columns
                int n=Integer.parseInt(br.readLine());

                int A[][]=new int[m][n]; //creating a 2D array

                /* Inputting the 2D Array */

                for(int i=0;i<m;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        System.out.print("Enter the elements: ");
                        A[i][j]=Integer.parseInt(br.readLine());
                    }
                }        

                /* Printing the original 2D Array */

                System.out.println("The original array:");
                for(int i=0;i<m;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        System.out.print(A[i][j]+"\t");
                    }
                    System.out.println();
                }

                /* Sorting the 2D Array */

                int t=0;
                for(int x=0;x<m;x++)
                {
                    for(int y=0;y<n;y++)
                    {
                        for(int i=0;i<m;i++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                if(A[i][j]>A[x][y])
                                {
                                    t=A[x][y];
                                    A[x][y]=A[i][j];
                                    A[i][j]=t;
                                }
                            }
                        }
                    }
                }

                /* Printing the sorted 2D Array */

                System.out.println("The Sorted Array:");
                for(int i=0;i<m;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        System.out.print(A[i][j]+"\t");
                    }
                    System.out.println();
                }
            }
        }