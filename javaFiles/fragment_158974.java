@NamedNativeQueries({
    @NamedNativeQuery(
    name = "findStockByStockCodeNativeSQL",
    query = "select * from stock s where s.stock_code = :stockCode",
        resultClass = Stock.class
    )
})
@Entity
@Table(name = "stock", catalog = "mkyong")
public class Stock implements java.io.Serializable {