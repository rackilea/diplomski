import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService
{
    @GET("/api/?type=all-meat&paras=10&start-with-lorem=10")
    Observable<List<String>> getProductData();
}