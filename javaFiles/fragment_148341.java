int n = in.nextInt();
        int q = in.nextInt();
        String s = in.next();
        int[][] cur = new int[n][];
        int[][] count = new int[n][n];
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = Z(s.substring(i).toCharArray());//Applying Z algorithm
            for (int j = 1; j < cur[i].length; j++) {
                if (cur[i][j] > length[j + i]) {
                    for (int k = i + length[j + i]; k < i + cur[i][j]; k++) {
                        count[i][k]++;
                    }
                    length[j + i] = cur[i][j];
                }

            }
        }
        int[] F = new int[n + 1];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int v = count[i][j] + (length[i] < (j - i + 1) ? 1 : 0);
                F[v]++;
            }
        }