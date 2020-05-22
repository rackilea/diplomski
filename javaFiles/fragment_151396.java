public static Specification<Activity> activityDateBetween(ZonedDateTime from, ZonedDateTime to) {
            return new Specification<Activity>() {
                @Override
                public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    Predicate startingFrom =  criteriaBuilder.greaterThanOrEqualTo(root.get(Activity_.date),
                        from.minusHours(from.getHour()).minusMinutes(from.getMinute()).minusSeconds(from.getSecond()));
                    Predicate endingAt = criteriaBuilder.lessThanOrEqualTo(root.get(Activity_.date), to);
                    return criteriaBuilder.and(startingFrom, endingAt);
                }
            };
        }