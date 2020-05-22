public static br.com.helper.EntityManagerFactoryHelper.getFactory;

public EmployeeService {

    public void doSomething() {
        EntityManager eManager = getFactory().createEntityManager();
        eManager.getTransaction().begin();

        EmployeeRepository repository = new EmployeeRepository(eManager);

        eManager.getTransaction().commit();
    }

}