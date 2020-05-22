@Component
public class RoleCrudHandler implements CrudHandler {

  private static final String ENTITY_NAME = "role";
  public static final String CREATE_VIEW = "role/create";
  public static final String EDIT_VIEW = "role/edit";
  @Resource
  private RoleService roleService;
  @Resource
  private RoleValidator validator;
  @Resource
  private CrudHandlerFactory handlerFactory;

  @PostConstruct
  public void init() {
    handlerFactory.register(ENTITY_NAME, this);
  }

  @Override
  public GenericService getService() {
    return roleService;
  }

  @Override
  public Validator getCreateValidator() {
    return validator;
  }

  @Override
  public Validator getUpdateValidator() {
    return validator;
  }

  @Override
  public BaseEntity createEntity() {
    return new Role();
  }

  @Override
  public void preSave(BaseEntity entity) {
  }

  @Override
  public String getCreateView() {
    return CREATE_VIEW;
  }

  @Override
  public String getUpdateView() {
    return EDIT_VIEW;
  }
}