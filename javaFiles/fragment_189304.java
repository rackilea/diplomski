import play.mvc.EssentialFilter;
import play.filters.cors.CORSFilter;
import play.http.HttpFilters;
import play.filters.csrf.CSRFFilter;
import play.filters.headers.SecurityHeadersFilter;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
public class Filters implements HttpFilters {
    @Inject 
    CSRFFilter csrfFilter;
    @Inject
    CORSFilter corsFilter;
    @Inject 
    SecurityHeadersFilter secHeaders;

    @Override
    public List<EssentialFilter> getFilters() {

        return Arrays.<EssentialFilter>asList(new EssentialFilter[] { corsFilter.asJava(),secHeaders.asJava(), csrfFilter.asJava()});
                }
}