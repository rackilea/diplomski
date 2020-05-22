@Target(
{
    ElementType.TYPE, ElementType.METHOD
})
@Component
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@PreAuthorize("hasAuthority('PERM_READ_SETTINGS')") 
public @interface SettingsAuthorized
{

}