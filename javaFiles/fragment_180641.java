package cucumber.testbeans;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.web.client.*;

/**
* Essentially an {@link UnorderedRequestExpectationManager}, but overrides some implementations of {@link AbstractRequestExpectationManager}
* in order to allow adding more expectations after the first request has been made.
*/
public class RestRequestExpectationManager extends AbstractRequestExpectationManager {

    private final RequestExpectationGroup remainingExpectations = new RequestExpectationGroup();

    @Override
    public ResponseActions expectRequest( ExpectedCount count, RequestMatcher matcher ) {
        //        Assert.state(getRequests().isEmpty(), "Cannot add more expectations after actual requests are made.");
        RequestExpectation expectation = new DefaultRequestExpectation( count, matcher );
        getExpectations().add( expectation );
        return expectation;
    }

    @Override
    public ClientHttpResponse validateRequest( ClientHttpRequest request ) throws IOException {
        //        if (getRequests().isEmpty()) {
        afterExpectationsDeclared();
        //        }
        ClientHttpResponse response = validateRequestInternal( request );
        getRequests().add( request );
        return response;
    }

    @Override
    protected void afterExpectationsDeclared() {
        this.remainingExpectations.updateAll( getExpectations() );
    }

    @Override
    public ClientHttpResponse validateRequestInternal( ClientHttpRequest request ) throws IOException {
        RequestExpectation expectation = this.remainingExpectations.findExpectation( request );
        if ( expectation != null ) {
            ClientHttpResponse response = expectation.createResponse( request );
            this.remainingExpectations.update( expectation );
            return response;
        }
        throw createUnexpectedRequestError( request );
    }

    /**
    * Same as {@link AbstractRequestExpectationManager.RequestExpectationGroup}, but synchronizes operations on the {@code expectations}
    * set, so async operation would be possible.
    */
    private static class RequestExpectationGroup {

        private final Set<RequestExpectation> expectations = Collections.synchronizedSet( new LinkedHashSet<>() );

        public Set<RequestExpectation> getExpectations() {
            return this.expectations;
        }

        public void update( RequestExpectation expectation ) {
            if ( expectation.hasRemainingCount() ) {
                getExpectations().add( expectation );
            } else {
                getExpectations().remove( expectation );
            }
        }

        public void updateAll( Collection<RequestExpectation> expectations ) {
            for ( RequestExpectation expectation : expectations ) {
                update( expectation );
            }
        }

        public RequestExpectation findExpectation( ClientHttpRequest request ) throws IOException {
            synchronized ( this.expectations ) {
                for ( RequestExpectation expectation : getExpectations() ) {
                    try {
                        expectation.match( request );
                        return expectation;
                    } catch ( AssertionError error ) {
                        // Ignore
                    }
                }
                return null;
            }
        }
    }
}