private int[] g_from = new int[6];
private int[] g_to = new int[6];

public Integer traverse(Integer fromNode,Integer length) {
    for(int i = 0; i < g_from.length; i++) {
        if(g_from[i] == fromNode) {
            return traverse(g_to[i],++length);
        }
    }
    return length;
}

public Integer findLongestRoute() {
    int l = 0;

    for(int i = 0; i < g_from.length; i++) {
        int length = traverse(g_from[i],0);
        if(length > l) {
            l = length;
        }
    }

    return l;
}