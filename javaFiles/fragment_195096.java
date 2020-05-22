@Entity
@Table(name="MAIN_TABLE")
public class MainTable {
    @Id
    @Type(type = "LongToNull")
    private long id; 

    @OneToMany(mappedBy = "mainTable")
    private List<JoinTable> joinTableRecords = new ArrayList<JoinTable>();
}

@Entity
@Table(name="THIRD_TABLE")
public class ThirdTable {
    @Id
    @Type(type = "LongToNull")
    private long id; 

    @OneToMany(mappedBy = "thirdTable")
    private List<JoinTable> joinTableRecords = new ArrayList<joinTable>();

    ...
}

@Entity
@Table(name="JOIN_TABLE")
public class JoinTable {
    @EmbeddedId
    private JoinTablePK pkId;

    private String irrelevantData;

    @ManyToOne
    @JoinColumn(name = "MAIN_TABLE_ID", insertable = false, updateable = false)
    private MainTable mainTable;

    @ManyToOne
    @JoinColumn(name = "THIRD_TABLE_ID", insertable = false, updateable = false)
    private ThirdTable thirdTable;

    ...
}

@Embeddable
public class JoinTablePK {
    @Column(name = "MAIN_TABLE_ID")
    private Long mainTableId;

    @Column(name = "THIRD_TABLE_ID")
    private Long thirdTableId;

    // getters and setters
}