class Terrain {

    private byte[] terrainData;
    private int terrainSizeX;
    private int terrainSizeY;

    public void init() {
        terrainData = new byte[terrainSizeX * terrainSizeY];
    }

    private int getIndex(int row, int column) {
        return terrainSizeX * column + row;
    }

    public byte getTerrainAtLocation(int row, int column) {
        return terrainData[getIndex(row, column)];
    }

    public void setTerrainAtLocation(int row, int column, byte value) {
        terrainData[getIndex(row, column)] = value;
    }
}