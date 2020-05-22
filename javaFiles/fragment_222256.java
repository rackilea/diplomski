@RequestLine("GET /Groups?filter={roleName}")
String isValidRole(@Param(value = "roleName", expander = PrefixExpander.class) String roleName);

static final class PrefixExpander implements Param.Expander {
    @Override
    public String expand(Object value) {
        return "displayName+Eq+" + value;
    }
}