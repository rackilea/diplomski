@Component
public class TenantValidator implements ConstraintValidator<ValidTenant, DecisionInput> {
    @Autowired
    private TenantDAO tenantDao;

    @Override
    public void initialize(ValidTenant annotation) {
    }

    @Override
    public boolean isValid(DecisionInput input, ConstraintValidatorContext context) {
        List<Tenant> userTenants = tenantDao.findTenantsForUser(input.getUser().getId());
       return userTenants.contains(input.getTenant());
    }
}