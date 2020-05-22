CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Issue> cq = cb.createQuery(Issue.class);

        Root<Issue> issue = cq.from(Issue.class);
        List<Predicate> predicates = new ArrayList<>();

        if (filters.getCategoryId() != null) {
            Category issueCategory = categoryRepository.findById(filters.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " +String.valueOf(filters.getCategoryId())));
            predicates.add(cb.equal(issue.get("category"), issueCategory));
        }
        if (filters.getPostedDays() != null) {
            Date startDate = issueUtility.getStartDateForFilterIssues(filters.getPostedDays());
            predicates.add(cb.between(issue.get("createdAt"), startDate,new Date()));
        }
        if (filters.getLatitude() != null && filters.getLongitude() != null) {
              // fetch by radius code comes here
            Expression<Issue> point1 = cb.function("point", Issue.class,
                    issue.get("latitude"),issue.get("longitude"));
            Expression<Double> point2 = cb.function("point", Double.class,
                    cb.literal(filters.getLatitude()),cb.literal(filters.getLongitude()));

            Expression<Number> distance = cb.function("ST_Distance_Sphere", Number.class,
                    point1,point2);
            predicates.add(cb.lt(distance,30000));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }