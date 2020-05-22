public class EmployeeSpecification {
    public static Specification<Employee> textInAllColumns(String text) {
        if (!text.contains("%")) {
            text = "%" + text + "%";
        }
        final String finalText = text;

        return  (Specification<Employee>) (root, query, builder) -> 
                builder.or(root.getModel().getDeclaredSingularAttributes().stream().filter(a -> {
                if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
                    return true;
                } else {
                    return false;
                }
            }).map(a -> builder.like(root.get(a.getName()), finalText)).toArray(Predicate[]::new));
    }
}