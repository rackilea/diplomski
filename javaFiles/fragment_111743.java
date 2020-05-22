@Embeddable    
public class Procurement_ID implements Serializable {

    /**
     * This attribute establishes the 1:1 connection to a record in the
     * "article" table. The column "articleId" is a foreign key to the column
     * "id" in the {@link Article} entity. (Warning: This is Hibernate
     * specific!)
     */
    @OneToOne
    @JoinColumn(name = "articleId", referencedColumnName = "id")
    private Article article;

    /**
     * This attribute establishes the 1:1 connection to a record in the table
     * "supplier". The column "supplierId" is a foreign key to the column "id"
     * in the {@link Supplier} entity. (Warning: This is Hibernate specific!)
     */
    @OneToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "id")
    private Supplier supplier;