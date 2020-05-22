@org.hibernate.annotations.Table(indexes = 
    @org.hibernate.annotations.Index(name = "IDX_REPORTID_RECNO",
        columnNames = {"reportId", "recNo"})
)
public class MyEntity {
    @org.hibernate.annotations.Index(name = "IDX_REPORTID")
    private Integer reportId;

    @org.hibernate.annotations.Index(name = "IDX_RECNO")
    private Integer recNo;
}