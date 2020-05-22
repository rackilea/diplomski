System.out.println("The matrix has " + rows + " randomized rows");
           System.out.println("The matrix has " + columns + " randomized column");

           System.out.println();

           System.out.println("The first matrix has the values: ");
           Matrix m1 = new Matrix(rows,columns);
           m1.print();
           System.out.println("---------------------------------");
           System.out.println("The second matrix has the values: ");
           Matrix m2 = new Matrix(columns, rows);

           m2.print();
           System.out.println();
           System.out.println("Product of A and B is");
           Matrix productRegular = m1.multiply(m2);
           productRegular.print();
        }
    }