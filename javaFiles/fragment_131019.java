@Entity
@Table(name = "EM_MONTHLY_POLL_TABLES")
public class EmMonthlyPollTablesEntity implements Serializable {

    @EmbeddedId
    private EmMonthlyPollTablesEntityPK id;

    @Column(name = "NAME")
    private String name;

    public EmMonthlyPollTablesEntityPK getId() {
        return id;
    }

    public void setId(EmMonthlyPollTablesEntityPK id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmMonthlyPollTablesEntity)) return false;
        EmMonthlyPollTablesEntity that = (EmMonthlyPollTablesEntity) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}