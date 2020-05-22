@Entity
@Table(name = "Sensor")
public class Sensor {
  // ...
  @OneToMany
  @JoinTable(
    name = "Sensor_Zone", 
    joinColumns = { @JoinColumn(name = "sensor_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "zone_id") }
  )
  private List<Zone> zones = new ArrayList<>();
}

@Entity
@Table(name = "Zone")
public class Zone {
  // ...
  @OneToMany
  @JoinTable(
    name = "Sensor_Zone", 
    joinColumns = { @JoinColumn(name = "zone_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "sensor_id") }
  )
  private List<Sensor> sensors = new ArrayList<>();
}