@Entity
@EntityListeners(DataHistoryListener.class)
@Table(name="person")
public class Person implements Serializable, DataHistoryAware {

@Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

@OneToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "data_history_id", nullable = false)
private DataHistory dataHistory;

public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
public DataHistory getDataHistory() {
        return dataHistory;
    }

    public void setDataHistory(DataHistory dataHistory) {
        this.dataHistory = dataHistory;
    }
}