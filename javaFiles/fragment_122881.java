import org.eclipse.persistence.config.PersistenceUnitProperties;
//define your datasource before proxyDS - not shown here
//then add this property to entity manager factory prop map

emfProps.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, proxyDS);
EntityManagerFactory emf = Persistence.createEntityManagerFactory("CompanyPU", emfProps);
EntityManager em = emf.createEntityManager();