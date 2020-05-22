public boolean overlaps(AreaSelection other)
{
    boolean Xs = overlap_1D(lowX,highX,other.getLowestX(),other.getHighestX());
    boolean Ys = overlap_1D(lowY,highY,other.getLowestY(),other.getHighestY());
    boolean Zs = overlap_1D(lowZ,highZ,other.getLowestZ(),other.getHighestZ());
    return (Xs && Ys && Zs);        
}