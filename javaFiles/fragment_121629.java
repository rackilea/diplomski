for(int z = 0; z < 500; z++) {
    int x1 = nmb.nextInt(200) + 1;
    int x2 = nmb.nextInt(200) + 1;
    int x3 = nmb.nextInt(200) + 1;

    int x4 = nmb.nextInt(500) + 1;
    int x5 = nmb.nextInt(500) + 1;
    int x6 = nmb.nextInt(500) + 1;

    int x7 = nmb.nextInt(500) + 1;
    int x8 = nmb.nextInt(500) + 1;
    int x9 = nmb.nextInt(500) + 1;

    g.setColor(new Color(x1, x2, x3));
    g.fillPolygon(new int[]{x4, x5, x6}, new int[]{x7, x8, x9}, 3);
}