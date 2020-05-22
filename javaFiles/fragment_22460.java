@Entity
public class X implements Serializable {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="y_fk")
    public Y getY() {
        ...
    }

@Entity
public class Y implements Serializable {
    @OneToOne(mappedBy = "y")
    public X getX() {
    ...
}