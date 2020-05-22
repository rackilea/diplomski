private static String wordInSeq(String s) {
        int[][] dp = new int[s.length()][2];
        int max_index = -1;
        for(int i=0;i<s.length();++i){
            dp[i][0] = 1;
            dp[i][1] = i;
            for(int j=i-1;j>=0;--j){
                if(s.charAt(i) > s.charAt(j)){
                    if(dp[i][0] < 1 + dp[j][0]){
                        dp[i][0] = 1 + dp[j][0];
                        dp[i][1] = j;
                    }
                }
            }

            if(max_index == -1 || dp[max_index][0] < dp[i][0]) max_index = i;
        }

        StringBuilder res = new StringBuilder("");
        int temp = max_index;
        while(dp[temp][1] != temp){
            res.append(s.charAt(temp));
            temp = dp[temp][1];
        }
        res.append(s.charAt(temp));
        return res.reverse().toString();
    }