@Compnonent
MyTransactionManager
{
@Autowired
EntityManagerFactory entityManagerFactory;

...Constructor to set properties and entityManagerFactory
...Getters and setters

}

@Component
entityManagerFactory{
persistenceUnitName

@Autowired
PersistenceUnitManager persistenceUnitManager

...Constructor to set properties and persistenceUnitManager
...Getters and setters
}

@Component
persistenceUnitManager{
Values as described in properties file, for example like

public @Value("${version}") String version;

...Constructor to set properties 
...Getters and setters

}