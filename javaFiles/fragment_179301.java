@Dao
public interface CartDao
{
    @Query("SELECT * FROM product")
    ArrayList<Product> getAllProduct();


    @Delete
    void delete(Product cart);
}