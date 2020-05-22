for (int ver = 0; ver < G.V(); ver++) {
    int dis = G.distTo(ver);
    if (distArray[dis] == 0) {
        distArray[dis] = findUnusedColor(colorList);
        colorList.add(distArray[dis]);
    }
    colorArray[ver] = distArray[dis];
}