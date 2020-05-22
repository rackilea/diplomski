public class UserSpecifications {

    public static Specification<User> findUniqueUser(Integer userId){

         return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> userRoot,
                    CriteriaQuery<?> criteriaQ, CriteriaBuilder critieriaB) {
                criteriaQ.distinct(true);
                return critieriaB.equal(userRoot.get(User_.id), 1);
            }

         };
    }
}