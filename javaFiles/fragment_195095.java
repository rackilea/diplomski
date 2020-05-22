@Entity
@Table(name="MAIN_TABLE")
public class MainTable {
    @Id
    @Type(type = "LongToNull")
    private long id; 

    @ManyToMany
    @JoinTable(name = "JOIN_TABLE", joinColumns = @JoinColumn(name = "JOIN_TABLE_ID"),
      inverseJoinColumns = @JoinColumn(name = "THIRD_TABLE_ID")
    private List<ThirdTable> thirdTableRecords = new ArrayList<ThirdTable>();
}

@Entity
@Table(name="THIRD_TABLE")
public class ThirdTable {
    @Id
    @Type(type = "LongToNull")
    private long id; 

    @ManyToMany(mappedBy = "thirdTableRecords")
    private List<MainTable> mainTableRecords = new ArrayList<MainTable>();

    ...
}