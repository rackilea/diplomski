public class q1 {
    List<List<Integer>> L; 
    public void set(int m, int n){
        L = new ArrayList<>(m); // assuming m is the number or rows
        for(int i = 0; i < m; ++i) {
            L.add(new ArrayList<>(n)); 
        }
        // now you have a List of m lists where each inner list has n items
    }
}