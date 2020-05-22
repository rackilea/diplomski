public void printArrayProduct() {
    String[][] groups = new String[][]{
                                   {"Hello", "Goodbye"},
                                   {"World", "Everyone"},
                                   {"Here", "There"}
                        };
    subProduct("", groups, 0);
}

private void subProduct(String partProduct, String[][] groups, int down) {
    for (int across=0; across < groups[down].length; across++)
    {
        if (down==groups.length-1)  //bottom of the array list
        {
            System.out.println(partProduct + " " + groups[down][across]);
        }
        else
        {
            subProduct(partProduct + " " + groups[down][across], groups, down + 1);
        }
    }
}