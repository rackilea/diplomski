import java.util.List;

import org.hibernate.SessionFactory;

public class CustomerDaoImpl implements CustomerDao{
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;}
    public void setSessionFactory(SessionFactory sessionFactory) {
         this.sessionFactory = sessionFactory;
    }

    public void addCustomer(Customer customer){


        getSessionFactory().getCurrentSession().save(customer);

    }

    public List<Customer> findAllCustomer(){

        List list = getSessionFactory().getCurrentSession().createQuery("from Customer").list();
        return list;

    }
}