public class Car extends Vehicle implements Visitable {
    ...
    <T> T accept(VehicleVisitor<T> visitor){
        return visitor.visit(this);
    }
    ...
}