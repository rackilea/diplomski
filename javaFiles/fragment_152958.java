public static boolean hasPathHelper(int[][] m, int[][] v, int i, int j){
    if(i < 0 || j < 0 || i >= m.length || j >= m[0].length || v[i][j] >= 0)
        return false;                        // Index out of bounds

    v[i][j] = 0;                             // Mark as visited
    if(m[i][j] == 0)                         // Path stops here
        return false;
    if(j == m[0].length - 1 ||               // Right side reached!
       hasPathHelper(m, v, i - 1, j + 1) ||  // Check upper right
       hasPathHelper(m, v, i + 1, j + 1) ||  // Check lower right
       hasPathHelper(m, v, i + 1, j - 1) ||  // Check lower left
       hasPathHelper(m, v, i + 1, j - 1) ||  // Check upper left
       hasPathHelper(m, v, i + 1, j    ) ||  // Check down
       hasPathHelper(m, v, i - 1, j    ) ||  // Check up
       hasPathHelper(m, v, i    , j + 1) ||  // Check right
       hasPathHelper(m, v, i    , j - 1)     // Check left
    ) v[i][j] = 1;                           // Mark as good path

    return v[i][j] == 1;
}

public static boolean hasPath(int[][] m, int[][] v){
    for(int i = 0; i < m.length; i++)
        if(hasPathHelper(m, v, i, 0))
            return true;

    return false;
}

public static void main(String... args){
    int[][] m = { {0,1,1,1,0},
                  {1,0,0,1,0},
                  {0,0,1,1,0},
                  {0,1,0,0,0},
                  {0,0,1,1,1} };

    int[][] v = new int[5][5];                         // v => -1, not visited
    for(int i=0; i<5; i++)                             // v =>  0, visited bad path
        Arrays.fill(v[i], -1);                         // v =>  1, visited good path

    System.out.println("Has Path?: " + hasPath(m, v));
    System.out.println("Path Matrix: ");
    for(int i = 0; i < v.length; i++)
        System.out.println(Arrays.toString(v[i]));    
}