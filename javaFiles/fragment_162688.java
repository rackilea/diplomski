import org.hibernate.criterion.Order;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;

public class CustomerOrder extends Order {

    private String companyAlias
    private String userAlias
    private boolean ascending

    protected CustomerOrder(String userAlias, String companyAlias, boolean ascending) {
        super("", true);
        this.companyAlias = companyAlias
        this.userAlias = userAlias
        this.ascending = ascending
    }

    public String toString() {
        return companyAlias  + "-" + userAlias;
    }

    public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
        String[] firstName = criteriaQuery.getColumnsUsingProjection(
            criteria, "${userAlias}.firstName");
        String[] lastName = criteriaQuery.getColumnsUsingProjection(
            criteria, "${userAlias}.lastName");

        String[] companyId = criteriaQuery.getColumnsUsingProjection(
            criteria, "${companyAlias}.id");
        String[] companyName = criteriaQuery.getColumnsUsingProjection(
            criteria, "${companyAlias}.name");

        """
            CASE WHEN ${companyId[0]} IS NULL
                THEN LOWER(RTRIM(LTRIM(${lastName[0]} + ', ' + ${firstName[0]})))
                ELSE LOWER(RTRIM(LTRIM(${companyName[0]})))
            END ${ascending ? "asc" : "desc" }
        """
    }

    public static Order by(String userAlias, String companyAlias, String direction) {
        boolean ascending = (!direction || direction.equalsIgnoreCase('asc'));
        return new CustomerOrder(userAlias, companyAlias, ascending);
    }
}