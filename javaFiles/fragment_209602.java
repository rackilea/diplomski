@Entity
@DiscriminatorValue("OFFICE")
public class Office extends Building {
    @OneToMany(mappedBy = "buildingId",
        fetch = FetchType.EAGER,
        cascade = {CascadeType.ALL},
        orphanRemoval = true)
    private Set<BuildingFloors> buildingFloors;
}