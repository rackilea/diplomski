package net.andreaskluth.hibernatesample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeService {

  private SessionFactory hibernateFactory;

  @Autowired
  public SomeService(EntityManagerFactory factory) {
    if(factory.unwrap(SessionFactory.class) == null){
      throw new NullPointerException("factory is not a hibernate factory");
    }
    this.hibernateFactory = factory.unwrap(SessionFactory.class);
  }

}