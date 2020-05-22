StringTokenizer st = new StringTokenizer("abc_12.23;dcf_23.99;dfa_12.99", "_;");
    int n = st.countTokens();
    String[] sa = new String[n / 2];
    float[] fa = new float[n / 2];
    for(int i = 0 ; st.hasMoreTokens(); i++) {
        sa[i] = st.nextToken();
        fa[i] = Float.parseFloat(st.nextToken());
    }