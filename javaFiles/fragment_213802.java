static String s[] = {"HYUBN", "ESD", "LOP", "LOP", "OKL"};
    static ArrayList<String> comb; // arraylist is going to hold results.

    static void dfs(String x,int i) {
        if(i == s.length) {   // there is no more string that can be generated
            comb.add(x); // save the found string
            return;
        }
        for(int j=0;j<s[i].length();j++)  // for each character in the current string
            dfs(x+s[i].charAt(j),i+1); // take the current character and move to the next string
    }

    public static void main(String[] args) {
        comb = new ArrayList<>();
        dfs("",0);
        for(String x:comb) out.print(x + " ");
    }