@Name("nonEjbComponent")
public class NonEjbComponent {

    private @In DaoEjbComponent daoEjbComponent;
    private @In OtherDaoEjbComponent otherDaoEjbComponent;
    private @In AnotherDaoEjbComponent anotherDaoEjbComponent;

    private @In UserTransaction userTransation;

    public void wrapperAllOfThem() {

         userTransation.begin();

             daoEjbComponent.save(someEntity);
             otherDaoEjbComponent.update(otherEntity);
             anotherDaoEjbComponent.delete(anotherEntity);

         userTransation.commit();

    }

}