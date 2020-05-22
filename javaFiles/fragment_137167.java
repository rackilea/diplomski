import com.sun.jersey.api.container.filter.LoggingFilter;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;

public class LogFilter extends LoggingFilter implements ContainerRequestFilter {

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) {
        // gets called when the request comes in
        startTime.set(System.currentTimeMillis());
        return containerRequest;
    }

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        // gets called when the response is about to be returned
        // do the logging here
        return response;
    }

}