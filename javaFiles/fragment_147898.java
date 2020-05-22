@Entity
public class BusStation {
    ...
    @ManyToMany
    @JoinTable(name = "busStation_to_busLine", joinColumns = @JoinColumn(name = "busStation_id"),
      inverseJoinColumns = @JoinColumn(name = "busLine_id")
    private List<BusLine> busLines = new ArrayList<BusLine>();
    ...
}

@Entity
public class BusLine {
    ...
    @ManyToMany(mappedBy = "busLines")
    private List<BusStation> busStations = new ArrayList<BusStation>();
    ...
}