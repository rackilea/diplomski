abstract class Vehicle {
    @JsonView(Detail.Basic.class)
    private String brand;
    @JsonView(Detail.Standard.class)
    private int nbOfWheels;
}

class Car extends Vehicle {
    @JsonView(Detail.FullCar.class)
    private int nbOfDoors;
    // multiple views on a field
    @JsonView({Detail.Standard.class, Detail.Type.class})
    private boolean electric;
}

class Bike extends Vehicle {
    @JsonView(Detail.FullBike.class)
    private int tirePressure;
    @JsonView({Detail.Standard.class, Detail.Type.class})
    private boolean allTerrain;
}

class Detail {
    // marker interfaces never implemented
    interface Basic {}
    interface Type {}
    interface Standard extends Basic {}
    interface FullCar extends Basic {}
    interface FullBike extends Basic {}
    // 1 view can inherit from many
    interface Full extends FullCar, FullBike {}
}

ObjectMapper mapper = new ObjectMapper();
// only 1 view per writer
ObjectWriter basicWriter = mapper.writerWithView(Detail.Basic.class);
ObjectWriter standardWriter = mapper.writerWithView(Detail.Standard.class);
ObjectWriter typeWriter = mapper.writerWithView(Detail.Type.class);