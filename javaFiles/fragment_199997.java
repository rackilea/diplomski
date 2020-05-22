// convenience map for looking up appropriate property
private Map<Side, DoubleProperty> propLookup ;

public void close(Side... sides) {

    Timeline t = new Timeline() ;
    Duration d = Duration.seconds(0.5);
    for (Side s : sides) {
        t.getKeyFrames().add(new KeyFrame(d, new KeyValue(propLookup.get(s), 0));
    }
    t.play();
}

public void closeAll() {
    close(Side.TOP, Side.RIGHT, Side.BOTTOM, Side.LEFT);
}