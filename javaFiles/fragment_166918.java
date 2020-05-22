for(int[]row:values)
    {
        for(int rowIndex = 0; rowIndex < row.length(); rowIndex++)
        {
            System.out.print(row[rowIndex]);
            System.out.print("\t");

            if(rowIndex == 2 || rowIndex == 5) {
                 System.out.print("|");
                 System.out.print("\t");
            }
        }
        System.out.println();
    }
}