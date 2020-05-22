import org.springframework.web.filter.GenericFilterBean;

public class TokenAuthorizationFilter extends GenericFilterBean {

    private final EnrollCashRepository enrollCashRepository;

    public TokenAuthorizationFilter(EnrollCashRepository enrollCashRepository) 
    {
        this.enrollCashRepository = enrollCashRepository
    }
}