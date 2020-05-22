@Embeddable
public class D3 {
    float z;
    @Enumerated(EnumType.STRING)
    Figure figure;

    public D3() { //I've added this
    }

    public D3(float z, Figure f) {
        this.z = z;
        this.figure = f;
    }
}