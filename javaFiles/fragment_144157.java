@BindingAnnotation(BindRole.RoleBinderFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindRole
{
    public static class RoleBinderFactory implements BinderFactory
    {
        public Binder build(Annotation annotation)
        {
            return new Binder<BindRole, User>()
            {
                public void bind(SQLStatement q, BindRole bind, Role role)
                {
                    q.bind("id", role.getId());
                    q.bind("name", role.getName());
                    q.define("role", role);
                }
            };
        }
    }
}