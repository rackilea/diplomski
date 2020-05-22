@Table(database = AppDatabase.class)
public class CafeWebContentCategories extends BaseModel {
    @PrimaryKey
    private int id;

    @Column
    private int categoryServerId;

    @PrimaryKey
    @Column
    public int cafeServerId;

    @Column
    private String title;

    @Column
    private boolean isAuto;

    public List<CafeWebChildContentCategories> subContentCategories;

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "subContentCategories")
    public List<CafeWebChildContentCategories> getMyChannelSubContentCategories() {
        if (subContentCategories == null || subContentCategories.isEmpty()) {
            subContentCategories = SQLite.select()
                    .from(CafeWebChildContentCategories.class)
                    .where(CafeWebChildContentCategories_Table.parentId.eq(cafeServerId))
                    .queryList();
        }
        return subContentCategories;
    }

    public CafeWebContentCategories() {
    }

    // setters and getters
}