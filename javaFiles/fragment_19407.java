public static void main(String[] args) {
        String[][] b = {{"John", "Abby"},
                        {"Sally", "Tom"}};

//      System.out.println(firstRow(b)); // line 8
        String[] result = firstRow(b);
        for(int i = 0; i < result.length; i++)
            System.out.print(firstRow(b)[i] + " ");
    }

    public static String[] firstRow(String[][] a) {    
        return a[0];
    }