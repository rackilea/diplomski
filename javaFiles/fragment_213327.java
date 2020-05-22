@Entity
@Table(name="PRODUCT")
class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    protected Integer productId;

    @Column(name = "NAME")
    protected String name;

    @Formula("(select MAGIC_VALUE from STATISTICS where PRODUCT_ID_FK = PRODUCT_ID)")
    protected String magicValue;
}