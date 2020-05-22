/**
 * Enables provided Hibernate filters every time a Hibernate session is openned.
 * 
 * Must be enabled and configured explicitly from Spring XML config (i.e. no auto-scan here)
 *
 * @author Val Blant
 */
@Aspect
public class HibernateForceFiltersAspect {

    List<String> filtersToEnable = [];

    @PostConstruct
    public void checkConfig() throws Exception {
        if ( filtersToEnable.isEmpty() ) {
            throw new IllegalArgumentException("Missing required property 'filtersToEnable'");
        }
    }

    /**
     * This advice gets executed before all method calls into DAOs that extend from <code>HibernateDao</code>
     * 
     * @param jp
     */
    @Before("@target(org.springframework.stereotype.Repository) && execution(* ca.gc.agr.common.dao.hibernate.HibernateDao+.*(..))")
    public void enableAllFilters(JoinPoint jp) {
        Session session = ((HibernateDao)jp?.getTarget())?.getSession();

        if ( session != null ) {
            filtersToEnable.each { session.enableFilter(it) } // Enable all specified Hibernate filters
        }
    }

}