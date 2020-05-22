private static HashMap<String, List<String>> cache = new HashMap<String, List<String>>();

    public static List<String> solution(int len, int n) {
        return rec(len, n, 0);
    }

    public static List<String> rec(int len, int n, int r) {
        String key = len + "#" + n + "#" + r;
        if (cache.containsKey(key))
            return cache.get(key);
        List<String> retVal = new ArrayList<String>();
        if (len == 1) {
            if (n == r)
                retVal.add("(");
            if (n == 0)
                retVal.add(")");
            return retVal;
        }
        List<String> rightParenSet = rec(len - 1, n, r + 1);
        List<String> leftParenSet = rec(len - 1, n - r, r);

        for (String s : rightParenSet)
            retVal.add(s + ")");
        for (String s : leftParenSet)
            retVal.add(s + "(");

        cache.put(key, retVal);

        return retVal;
    }

    public static void main(String[] args) {
        List<String> strings = solution(4, 3);
        for(String s : strings)
            System.out.println(s);
    }