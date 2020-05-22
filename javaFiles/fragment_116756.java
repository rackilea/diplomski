@Embeddable
public class Products implements Serializable {

    @Column(name = "product_des1")
    private String description1;

    @Column(name = "product_amt1")
    private String amount1;

    @Column(name = "product_des2")
    private String description2;

    @Column(name = "product_amt2")
    private String amount2;

   // ... repeat
}