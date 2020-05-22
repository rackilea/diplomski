package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import model.Student;

public class StudentDaoImplHT implements StudentDaoInterface {

    private HibernateTemplate ht;

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }

    @Override
    @Transactional(readOnly = false)
    public int save(Student st) {

        int i=(Integer)ht.save(st);
        return i;
    }

                    .
                    .
                    .
                    .

}