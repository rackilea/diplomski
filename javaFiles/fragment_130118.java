public static void largestProduct() throws FileNotFoundException {
Scanner s;
s = new Scanner(new File("p11.txt")); // Read in numbers from grid file
ArrayList<Integer> a = new ArrayList<Integer>();  
int product = 0;

while (s.hasNext()) {
a.add(s.nextInt());
}

for (int i = 0; i < a.size(); i++) {
    int origin = a.get(i);
    int luHighest = 0;
    int ldHighest = 0;
    int ruHighest = 0;
    int rdHighest = 0;
    if(i>63){
        int lu_diag2 = a.get(i-21);
        int lu_diag3 = a.get(i-21-21);
        int lu_diag4 = a.get(i-21-21-21);
        luHighest = origin * lu_diag2 * lu_diag3 * lu_diag4;
    }
    if(i<a.size()-57){  
        int ld_diag2 = a.get(i+19);
        int ld_diag3 = a.get(i+19+19);
        int ld_diag4 = a.get(i+19+19+19);
        ldHighest = origin * ld_diag2 * ld_diag3 * ld_diag4;
    }
    if(i>57){ 
        int ru_diag2 = a.get(i-19);
        int ru_diag3 = a.get(i-19-19);
        int ru_diag4 = a.get(i-19-19-19);
        ruHighest = origin * ru_diag2 * ru_diag3 * ru_diag4;
    }
    if(i<a.size()-63){
        int rd_diag2 = a.get(i+21);
        int rd_diag3 = a.get(i+21+21);
        int rd_diag4 = a.get(i+21+21+21);
        rdHighest = origin * rd_diag2 * rd_diag3 * rd_diag4;
    }

    int highest = Math.max(Math.max(Math.max(rdHighest,ruHighest),ldHighest),luHighest);

    if (highest > product) {
    product = highest;
    }
}
System.out.println(product);
}