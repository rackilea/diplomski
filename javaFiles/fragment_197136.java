import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "/spring-SF-tests.xml",
        "/spring-transaction.xml"
})
@TransactionConfiguration(transactionManager="txManager", defaultRollback=true)
public abstract class HibernateAbstractTest extends AbstractTransactionalJUnit4SpringContextTests {
@Autowired
protected SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory sessionFactory){
    this.sessionFactory = sessionFactory;
}

public Session getSession(){
    return sessionFactory.getCurrentSession();
}

public void save(Object object){
    getSession().save(object);
}

public void update(Object object){
    getSession().update(object);
}
}