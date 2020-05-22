public interface InventoryDao extends JpaRepository<Inventory,Long> {

    @Query("FROM Inventory WHERE TYPE(item.class) = ?1")
    public List<Inventory> getInventoryByItem(Class<? extends Item> klazz);

}