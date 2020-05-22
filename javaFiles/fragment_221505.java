tChart1.getAspect().setView3D(false);
int gridWidth = 11;
int gridHeight = 11;

ColorGrid colorGrid1 = new ColorGrid(tChart1.getChart());
colorGrid1.setColorEach(true);
for (int x=0; x<gridWidth; x++) {
    for (int z=0; z<gridHeight; z++) {
        colorGrid1.add(x, 1, z, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
    }
}