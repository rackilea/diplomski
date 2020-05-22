public class ToRoleNameConverter extends DozerConverter<Role, String> {

    @SuppressWarnings("unchecked")
    public ToRoleNameConverter() {
       super(Role.class, String.class);
    }

    @Override
    public String convertTo(Role source, String destination) {
        return source.getName();
    }

    @Override
    public Role convertFrom(String source, Role destination) {
       throw new UnsupportedOperationException("Unsupported operation exception!");
   }
}