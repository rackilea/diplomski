@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Name("wrapperStateless")
public class WrapperStatelessImpl implements WrapperStateless {

    private @In DaoEjbComponent daoEjbComponent;
    private @In OtherDaoEjbComponent otherDaoEjbComponent;
    private @In AnotherDaoEjbComponent anotherDaoEjbComponent;

    public void wrapperAllOfThem() {

        daoEjbComponent.save(someEntity);
        otherDaoEjbComponent.update(otherEntity);
        anotherDaoEjbComponent.delete(anotherEntity);

    }

}