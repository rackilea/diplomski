import com.google.common.util.concurrent.RateLimiter;
public class SearchServer
{
     private static RateLimiter rateLimiter = RateLimiter.create(1.0d);

     static void doDelayQuery()
     {
        rateLimiter.acquire();
     }

     public doQuery()
     ..................
}