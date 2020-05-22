package com.pechen.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.pechen.entity.Person;

public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Person p) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Person> list() {
        Session session = sessionFactory.openSession();
        List<Person> rst = session.createQuery("from person").getResultList();
        session.close();
        return rst;
    }

}