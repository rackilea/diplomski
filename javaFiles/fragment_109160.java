@Entity
@Getter
@Setter
@Table(name = "activity_property")
@IdClass(ActivityPropertyId.class)
public class ActivityProperty {
    @ManyToOne
    @Id
    @JoinColumn(name="id", referencedColumnName="id")
    private Activity activity;

    @Id
    private String name;
    private String value;

}

@Getter
@Setter
@ToString
public class ActivityPropertyId implements Serializable {
    public ActivityPropertyId() {}

    @Column(name = "id")
    private Integer activity;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityPropertyId that = (ActivityPropertyId) o;
        return activity.equals(that.activity) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activity, name);
    }
}