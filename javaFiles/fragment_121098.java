public class MyEntityDAO{ 

    ....

    protected void save(MyEntity entity) {
      // check dates
      // throw some exception in a case of problems
      getCurrentSession().saveOrUpdate(entity);
    }
}