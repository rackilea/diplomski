public class UserSpecification {

    public static Specification<User> findByFirstNmLastNmEmailApp(String firstNm, String lastNm, String email, Collection<Long> appIds) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                final Collection<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(firstNm)) {
                    final Predicate firstNmPredicate = cb.like(cb.lower(root.get(User_.firstNm), firstNm));
                    predicates.add(firstNmPredicate);
                }
                if (!StringUtils.isEmpty(lastNm)) {
                    final Predicate lastNmPredicate = cb.like(cb.lower(root.get(User_.lastNm), lastNm));
                    predicates.add(lastNmPredicate);
                }
                if (!StringUtils.isEmpty(email)) {
                    final Predicate emailPredicate = cb.like(cb.lower(root.get(User_.email), email));
                    predicates.add(emailPredicate);
                }
                if (!appIds.isEmpty()) {
                    final Predicate appPredicate = root.join(User_.applications).get(Application_.applicationId).in(appIds);
                    predicates.add(appPredicate);
                }

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}