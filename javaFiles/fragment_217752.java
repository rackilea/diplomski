private Specification<Attendance> createSpecification(AttendanceCriteria criteria) {
    Specification<Attendance> specification = Specification.where(null);
    if (criteria != null) {
        if (criteria.getId() != null) {
            specification = specification.and(buildSpecification(criteria.getId(), Attendance_.id));
        }
        if (criteria.getDate() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getDate(), Attendance_.date));
        }
        if (criteria.getEnrollmentId() != null) {
            specification = specification.and(buildReferringEntitySpecification(criteria.getEnrollmentId(), Attendance_.enrollment, Enrollment_.id));
        }
        if (criteria.getStudentId() != null) {
            specification = specification.and(buildJoinSpecification(criteria.getStudentId(), Attendance_.enrollment, Enrollment_.student, Student_.id));
        }
        if (criteria.getCourseId() != null) {
            specification = specification.and(buildJoinSpecification(criteria.getCourseId(), Attendance_.enrollment, Enrollment_.course, Course_.id));
        }
    }
    return specification;
}

private <REFERENCE, JOIN, FILTER extends Comparable<? super FILTER>> Specification<Attendance> buildJoinSpecification(RangeFilter<FILTER> filter, SingularAttribute<? super Attendance, REFERENCE> reference, SingularAttribute<REFERENCE, JOIN> joinField, SingularAttribute<JOIN, FILTER> valueField) {
    Specification<Attendance> result = Specification.where((Specification) null);
    if (filter.getEquals() != null) {
        result = this.equalsSpecification(reference, joinField, valueField, filter.getEquals());
    }
    if (filter.getIn() != null) {
        result = this.valueIn((SingularAttribute) reference, joinField, valueField, filter.getIn());
    }
    return result;
}

private <REFERENCE, JOIN, FILTER> Specification<Attendance> equalsSpecification(SingularAttribute<? super Attendance, REFERENCE> reference, SingularAttribute<REFERENCE, JOIN> joinField, SingularAttribute<JOIN, FILTER> idField, FILTER value) {
    return (root, query, builder) ->
        builder.equal(root.join(reference).join(joinField).get(idField), value);
}

private <REFERENCE, JOIN, FILTER> Specification<Attendance> valueIn(SingularAttribute<? super Attendance, REFERENCE> reference, SingularAttribute<REFERENCE, JOIN> joinField, SingularAttribute<JOIN, FILTER> valueField, Collection<FILTER> values) {
    return (root, query, builder) -> {
        CriteriaBuilder.In<FILTER> in = builder.in(root.join(reference).join(joinField).get(valueField));
        for (FILTER value : values) {
            in = in.value(value);
        }
        return in;
    };
}