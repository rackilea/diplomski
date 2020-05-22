@RestController
public class RestControllerToProtect {
    // passing targetDomainObject and permission, authentication is detected by SecurityExpressionRoot
    @PreAuthorize("hasPermission(#abstractEntity, 'create')")
    public String methodToProtect(@RequestBody AbstractEntity abstractEntity) {
        return "Authenticated";
    }
}