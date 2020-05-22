@Entity
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "motorcycle_id"))
    })
    public class Motorcycle extends Vehicle {
        Boolean isTwoStroke;
    }