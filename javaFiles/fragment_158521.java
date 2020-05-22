public class q1 {
    Integer[][] L; 
    public void set(int m, int n){
        L = new Integer[m][]; // assuming m is the number or rows
        for(int i = 0; i < m; ++i) {
            L[i] = new Integer[n]; 
        }
        // now you have a array of m arrays where each inner array has n items
    }
}