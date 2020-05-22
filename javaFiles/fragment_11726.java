public interface Wheel {
    String getBarProp();
    Bike getBike();
}

public interface Bike {
    String getFooProp();
    Wheel getWheel();
}