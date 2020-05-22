/**
    * An utility method to build the Criterion Query IN clause if the number of parameter
    * values passed has a size more than 1000. Oracle does not allow more than
    * 1000 parameter values in a IN clause. Doing so a {@link SQLException} is
    * thrown with error code, 'ORA-01795: maximum number of expressions in a list is 1000'.
    * @param propertyName
    * @param values
    * @return
    */
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 2796
 */
public class SplitHibernateIn {

    private static int PARAMETER_LIMIT = 999;

    public static org.hibernate.criterion.Criterion buildInCriterion(String propertyName, List values) {
        org.hibernate.criterion.Criterion criterion = null;

        int listSize = values.size();
        for (int i = 0; i < listSize; i += PARAMETER_LIMIT) {
            List subList;
            if (listSize > i + PARAMETER_LIMIT) {
                subList = values.subList(i, (i + PARAMETER_LIMIT));
            } else {
                subList = values.subList(i, listSize);
            }
            if (criterion != null) {
                criterion = Restrictions.or(criterion, Restrictions.in(propertyName, subList));
            } else {
                criterion = Restrictions.in(propertyName, subList);
            }
        }
        return criterion;
    }
}