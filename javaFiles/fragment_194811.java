@Repository
public class ParentRepositoryImpl implements ParentRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public void updateSpecificUseCase(UpdateableParent updateableParentObject) {

        Parent parent = sessionFactory.getCurrentSession().load(Parent.class, updateableParentObject.getId());

        try {
            // jakarta commons takes care of copying Updateable Parent object to Parent object

            BeanUtils.copyProperties(parent, updateableParentObject);
        } catch (Exception e) {
            throw new IllegalStateException("Error occured when updating a Parent object", e);
        }

    }

}