class CarAttribute {
    private String attrib;
    public CarAttribute(String att){
        attrib = att;
    }
    // add getters and/or setters for attrib ... 
}

class CarModel extends CarAttribute {
}

class CarColor extends CarAttribute {
}

class Car {
    public final CarModel model;
    public final CarColor color;

    public Car(CarModel m, CarColor c) {
        model = m;
        color = c;
    }
}

class CarListRequest {
    public final CarAttribute sortBy;
    public final CarAttribute filterBy;
    public final List<CarAttribute> filterList;

    public CarListRequest(CarAttribute s, CarAttribute f, List<CarAttribute> list) {
        sortBy = s;
        filterBy = f;
        filterList = list;
    }
 }