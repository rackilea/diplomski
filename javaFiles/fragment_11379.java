public static void main(String[] args) {
    double A[][]= {
            { 3.152 ,96.1 , 77.12},
            { 608.12358 , -5.15412456453 , -36.1},
            { -753.555555,  6000.156564 , -155.541654}
        };
    //Number  of characters in format , here XXXX.XX length is 7
    int numberFormatLength=7;
    //Iterating through Array
    for(int i=0;i<A.length;i++){
        for(int j=0;j<A.length;j++){
            //Calculating number of spaces required.
            int spacesRequired=numberFormatLength-String.format("%.2f",A[i][j]).length();
            //Creating calculated number of spaces 
            String spaces = new String(new char[spacesRequired]).replace('\0', ' ');
            //formatting element to the format with  decimal place 2
            String arrayElement=String.format("%.2f",A[i][j]);
            //Using ternary operator to calculate what to print for every third Element in your array
            System.out.print((j/2==1)?(spaces+arrayElement+"\n"):(spaces+arrayElement+"|"));
        }

    }


}