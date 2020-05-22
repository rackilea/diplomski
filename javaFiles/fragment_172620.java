int row, col, n = 8;
int[][] grid = new int[n][n], cCount = new int[n][2], rCount = new int[n][2];
Deque<Entry<Integer,Integer>> freeInd = new ArrayDeque<Entry<Integer,Integer>>();
Random rand=new Random();
for(int i = 0; i < grid.length; i++){
    for(int j = 0; j < grid[0].length; j++){
        // Calcualte constraints: row, col = {-1, 0, 1},  -1 => no constraint.
        row = j > 1 && grid[i][j-2] == grid[i][j-1] ? (grid[i][j-1] == 0 ? 1:0):  
             (rCount[i][0] >= n/2 ? 1:                           // too many 0's
             (rCount[i][1] >= n/2 ? 0:-1));                      // too many 1's
        col = i > 1 && grid[i-2][j] == grid[i-1][j] ? (grid[i-1][j] == 0 ? 1:0):
             (cCount[j][0] >= n/2 ? 1:                           // too many 0's
             (cCount[j][1] >= n/2 ? 0:-1));                      // too many 1's
        grid[i][j] = row == -1 && col == -1 ? rand.nextInt(2):(row > -1 ? row:col);

        // Handle Constraints
        if( row == -1 && col == -1){                              // no constraint
            freeInd.push(new SimpleEntry<Integer,Integer>(i, j)); // add to free indices
        } else if( (row > -1 && col > -1 && row != col)           // constraint conflict
                || (row > -1 && rCount[i][row] >= n/2)            // count conflict
                || (col > -1 && cCount[j][col] >= n/2)){          // count conflict
            Entry<Integer, Integer> last = freeInd.pop();         // grab last free index
            while(i > last.getKey() || j > last.getValue()){
                j = (j-1+ n)%n;                                   // step indices back
                i = (j == n-1) ? i-1:i;   
                rCount[i][grid[i][j]]--;                          // reduce counters
                cCount[j][grid[i][j]]--;
            }
            grid[i][j] = grid[i][j] == 0 ? 1:0;                   // flip value
        }       
        rCount[i][grid[i][j]]++;                                  // increment counters
        cCount[j][grid[i][j]]++;
    }
}