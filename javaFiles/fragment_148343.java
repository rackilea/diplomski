for (int j = 1; j < cur[i].length; j++) {
            if (cur[i][j] > length[j + i]) {
                for (int k = i + length[j + i]; k < i + cur[i][j]; k++) {
                    count[i][k]++;
                }
                length[j + i] = cur[i][j];
            }          
        }