@Entity(name="AdmissionEvent")
@Subselect("SELECT fact_admission_event.fact_admission_event_key,fact_admission_event.ward FROM fact_admission_event")
@Synchronize({"fact_admission_event"})
public class AdmissionEvent {
@Id
@Column(name="fact_admission_event_key")
private int id;

@Column(name="ward")
private String wardLocation;

protected AdmissionEvent() {
}
{}