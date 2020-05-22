@Data
public class MyFilter implements Specification<MyEntity> {
    private String name;
    @DateTimeFormat(iso = ISO.DATE) private LocalDate from;
    @DateTimeFormat(iso = ISO.DATE) private LocalDate to;

    @Override
    public Predicate toPredicate(Root<MyEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        if (name != null) predicates.add(builder.like(builder.upper(root.get("name")), "%" + name.toUpperCase() + "%"));
        if (from != null) predicates.add(builder.greaterThanOrEqualTo(root.get("createdAt"), from));
        if (to != null) predicates.add(builder.lessThanOrEqualTo(root.get("createdAt"), to));
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}