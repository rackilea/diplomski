public enum ShipType {
SMALL{
    @Override
    public int[][] getRegionOfShip(int[] startingPosition, Aligment aligment){

    }
},
MEDIUM{
    @Override
    public int[][] getRegionOfShip(int[] startingPosition, Aligment aligment){

    }
};
public abstract int[][] getRegionOfShip(int[] startingPosition, Aligment aligment);