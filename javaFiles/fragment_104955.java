@Table(database = AppDatabase.class)
public class CafeWebChildContentCategories extends BaseModel {
    @PrimaryKey
    @Column
    public int id;

    @Column
    public int categoryId;

    @Column
    @ForeignKey(tableClass = CafeWebContentCategories.class,
            references = @ForeignKeyReference(columnName = "parentId", foreignKeyColumnName = "cafeServerId"))
    public int parentId;

    @Column
    private String title;

    public CafeWebChildContentCategories() {
    }

    // setters and getters
}