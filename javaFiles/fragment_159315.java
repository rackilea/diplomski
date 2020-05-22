import com.google.inject.Inject;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.PerRequestTypeInjectableProvider;
import java.util.List;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import org.joda.time.DateTime;

/**
 * Enables DateTime to be used as a QueryParam.
 * <p/>
 * @author Gili Tzabari
 */
@Provider
public class DateTimeInjector extends PerRequestTypeInjectableProvider<QueryParam, DateTime>
{
    private final com.google.inject.Provider<UriInfo> uriInfo;

    /**
     * Creates a new DateTimeInjector.
     * <p/>
     * @param uriInfo an instance of {@link UriInfo}
     */
    @Inject
    public DateTimeInjector(com.google.inject.Provider<UriInfo> uriInfo)
    {
        super(DateTime.class);
        this.uriInfo = uriInfo;
    }

    @Override
    public Injectable<DateTime> getInjectable(final ComponentContext cc, final QueryParam a)
    {
        return new Injectable<DateTime>()
        {
            @Override
            public DateTime getValue()
            {
                final List<String> values = uriInfo.get().getQueryParameters().get(a.value());
                if (values.size() > 1)
                {
                    throw new WebApplicationException(Response.status(Status.BAD_REQUEST).
                        entity(a.value() + " may only contain a single value").build());
                }
                if (values.isEmpty())
                    return null;
                return new DateTime(values.get(0));
            }
        };
    }
}