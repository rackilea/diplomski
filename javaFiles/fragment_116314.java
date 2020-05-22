@Data
@Entity
public class Device {

    @OneToMany(mappedBy = "device")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Collection<Container> containers = new ArrayList<>();

}


@Data
@Entity
public class Container {

    @ManyToOne
    private Device device;

}