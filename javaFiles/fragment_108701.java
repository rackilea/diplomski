@Entity
@Table(name="instanceOfClass")
public class InstanceOfClass {
(...)
    @OneToMany(fetch=FetchType.LAZY, mappedBy="instanceOfClass")
    public List<InstanceOfDataProperty> getDataProperties() {
        return dataProperties;
    }
(...)
}