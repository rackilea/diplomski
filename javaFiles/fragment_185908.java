public class ParentSpecification {

    public static Specification<Parent> byChildDate(Date one, Date two){
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.between(root.get("child").get("date"), one, two);
    }
}