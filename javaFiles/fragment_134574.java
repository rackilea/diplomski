import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import javax.inject.Inject;
import akka.stream.*;
import play.Logger;
import play.mvc.*;

public class LoggingFilter extends Filter {

    Materializer mat;

    @Inject
    public LoggingFilter(Materializer mat) {
        super(mat);
        this.mat = mat;
    }

    @Override
    public CompletionStage<Result> apply(
            Function<Http.RequestHeader, CompletionStage<Result>> nextFilter,
            Http.RequestHeader requestHeader) {
        long startTime = System.currentTimeMillis();
        return nextFilter.apply(requestHeader).thenApply(result -> {
            long endTime = System.currentTimeMillis();
            long requestTime = endTime - startTime;

            Logger.info("{} {} took {}ms and returned {}",
                requestHeader.method(), requestHeader.uri(), requestTime, result.status());
            akka.util.ByteString body = play.core.j.JavaResultExtractor.getBody(result, 10000l, mat);
            Logger.info(body.decodeString("UTF-8"));

            return result.withHeader("Request-Time", "" + requestTime);
        });
    }
}