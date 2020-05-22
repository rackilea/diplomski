import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.grocery.data.hibernate.Users;
import com.grocery.hibernate.SessionFactoryGroceries;

public class LoginBussiness {
    public static final Logger LOG = Logger.getLogger(LoginBussiness.class);

public String usersDetails(Integer loginId, String email, String password) {
    String name = "";
    Session session = null;
    try {
        session = SessionFactoryGroceries.getCurrentSession();
        Criteria criteria = session.createCriteria(Users.class);
        Criterion lhs = Restrictions.eq("userID", loginId);
        Criterion rhs = Restrictions.eq("email", email);
        criteria.add(Restrictions.or(lhs, rhs));
        criteria.add(Restrictions.eq("password", password));
        Users users = (Users) criteria.uniqueResult();
        if (users != null) {
            name = users.getFirstName();
        }
    } catch (Exception e) {
        e.printStackTrace();
        LOG.error("Type of exception occured in userDetails() is --> "+e);
    } finally {
        SessionFactoryGroceries.closeSession(session);
    }
    return name;
}