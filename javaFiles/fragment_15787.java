Map<VolunteerPojo, Integer> map =
using(configuration())
    .select(VOLUNTEER.fields())
    .select(VOLUNTEERMATCH.VOLUNTEERID.count())
    .from(VOLUNTEER)
    .leftJoin(VOLUNTEERMATCH)
    .on(VOLUNTEERMATCH.VOLUNTEERID.eq(VOLUNTEER.VOLUNTEERID))
    .groupBy(VOLUNTEER.fields())
    .fetchMap(
         r -> r.into(VOLUNTEER).into(VolunteerPojo.class),
         r -> r.get(VOLUNTEERMATCH.VOLUNTEERID.count())
    );