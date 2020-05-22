public class EmployeeDAO 
{
    HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    public void setSessionFactory(SessionFactory sessionFactory)
    {
 this.template=new HibernateTemplate(sessionFactory);
    }

    @Transactional(readOnly=false)
    public void saveEmployee(Employee e) 
    {
 template.saveOrUpdate(e);
    }
}