private DimensionTracker activedimension;
private Dimension overworld;
private Dimension otherdimension;

public Game() {
    overworld = new OverWorldDimension();
    otherdimension = new OtherDimension();
    activedimension.dimension = overworld;
}