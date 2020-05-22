CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
    Root<Project> root = criteriaQuery.from(Project.class);
    Join<Project, ProjectStatus> join = root.join("projectStatusses", JoinType.LEFT);

    //Create a subquery to get latest ProjectStatus for project
    Subquery sq = criteriaBuilder.createQuery().subquery(Long.class);
    Root<T> from = sq.from(Project.class);
    Path<ProjectStatus> path = root.join("projectStatusses");
    //Get latest status
    sq.select(criteriaBuilder.max(path.<Long>get("id")));
    //For each project
    sq.where(criteriaBuilder.equal(from.<Long>get("id"), root.<Long>get("id")));
    Predicate latestStatusCondition = criteriaBuilder.and(criteriaBuilder.equal(join.get("id"), sq));

    criteriaQuery.orderBy(criteriaBuilder.asc(join.get("statusType")));
    criteriaQuery.where(latestStatusCondition);