@Indexed
@Entity
public class Product {

  private int minimumStock;
  private int currentStock;


  @Transient
  @Field
  public int getMinmumStockDifference() {
    return currentStock - minimumStock;
  }

}