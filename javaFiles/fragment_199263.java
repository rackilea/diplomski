List<Integer> colorList = new ArrayList<Integer>();
int[] colorArray = new int[G.V()];
int[] distArray = new int[G.V()];
SimplerBreadthFirstPaths graph = new SimplerBreadthFirstPaths(G,0);

for (int dis = 0; dis < G.V(); dis++) {
    for (int ver = 0; ver < G.V(); ver++) {
        if (G.distTo(ver) == dis) {
            if (distArray[dis] == 0) {
                // Only assign a new color when a new distance occurs
                distArray[dis] = findUnusedColor(colorList);
                colorList.add(distArray[dis]);
            } 
            // Assign the color based on it's distance
            colorArray[ver] = distArray[dis];
        }
    }
}