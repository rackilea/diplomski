DetachedCriteria subquery = DetachedCriteria.forClass(Interview.class, "interview")
.setProjection(Projections.property("interview.candidate_id"));

DetachedCriteria criteria = DetachedCriteria.forClass(Candidate.class, "candidate")
.add(Subqueries.propertyNotIn("candidate.id", subquery));

Criteria executableCriteria = criteria.getExecutableCriteria(session);
List list = executableCriteria.list();