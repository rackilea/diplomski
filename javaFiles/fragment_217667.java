@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>  {

    @Query("SELECT inventory "
            + "FROM Inventory AS inventory "
            + "WHERE inventory.product.type = 'Phone' "
            + "OR inventory.product.type = 'Camera'")
    List<Inventory> findProducts();

}