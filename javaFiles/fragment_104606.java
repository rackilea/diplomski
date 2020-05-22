public class Organization {
    @Id
    private Long id;
    @Column
    private String name;
    @Embedded
    private Location location;
}

@Embeddable
public class Location {
    private Double lattitude;
    private Double longitude;
}