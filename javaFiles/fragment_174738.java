@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredPermission
{
    String permissionName();
    int permissionValue();
}