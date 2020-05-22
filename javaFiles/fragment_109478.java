public class CustomPermissionEvaluator implements PermissionEvaluator {

    private Logger log = LoggerFactory.getLogger(CustomPermissionEvaluator.class);

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        AbstractEntity abstractEntity = (AbstractEntity) targetDomainObject;
        log.debug("User {} trying to access {}-{} with permission {}",
                customUserDetails.getUsername(),
                abstractEntity.getClass().getSimpleName(),
                abstractEntity.getId(),
                permission.toString());
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        log.debug("User {} trying to access {}-{} with permission {}",
                customUserDetails.getUsername(),
                targetType,
                targetId,
                permission.toString());
        return false;
    }
}