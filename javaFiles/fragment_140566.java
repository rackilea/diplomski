// test data set up
int[][] data = {{1,1,1,1,0,0},
                {1,0,0,1,0,0},
                {1,0,0,1,0,1},
                {1,1,1,1,0,0},
                {0,0,1,1,0,0}};
int N = data.length, M = data[0].length;

// create queue of zeros on the "fringe"
Queue<int[]> fringe = new LinkedList<>();
for (int i = 0; i < N; i++) {
    if (data[i][0  ] == 0) fringe.add(new int[]{i,0  });
    if (data[i][M-1] == 0) fringe.add(new int[]{i,M-1});
}
for (int j = 0; j < M; j++) {
    if (data[0  ][j] == 0) fringe.add(new int[]{0  ,j});
    if (data[N-1][j] == 0) fringe.add(new int[]{N-1,j});
}   

// do flood fill until no more zeros reachable
while (! fringe.isEmpty()) {
    int[] next = fringe.poll();
    int i = next[0], j = next[1];
    data[i][j] = 2;
    for (int di = -1; di <= 1; di++) {
        for (int dj = -1; dj <= 1; dj++) {
            try {
                if (data[i+di][j+dj] == 0) fringe.add(new int[]{i+di, j+dj});
            } catch (ArrayIndexOutOfBoundsException e) {}
        }   
    }
}

// check for remaining zeros
boolean encircled = false;
for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
        System.out.print(data[i][j]);
        encircled |= data[i][j] == 0;
    }   
    System.out.println();
}
System.out.println(encircled);