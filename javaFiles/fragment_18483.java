public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {       
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        try { 
            em.setFlushMode(FlushModeType.COMMIT);          
            return userService.findByUsername(username) == null;

            } finally { 
           em.setFlushMode(FlushModeType.AUTO);
           }    
    }
}