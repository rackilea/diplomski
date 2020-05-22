package com.ford.cevs.scheduler.repository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class CommandStatusRepositoryImpl implements CommandStatusRepository {

@PersistenceContext
protected EntityManager em;

@Override
public String executeCommandStatusPurge(Integer minutes) {

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("MyProcedureName");

        // set parameters
        storedProcedure.registerStoredProcedureParameter("minutes", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("minutes", minutes);
        storedProcedure.execute();

        String result = (String)storedProcedure.getSingleResult();

        return result;
}
}