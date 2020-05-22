Table<?> from = table("links");
Condition where = trueCondition();

if (!StringUtils.isEmpty(place)) {
    long placeId = getPlaceId();

    if (placeId > 0) {
        from = from.join("place_links").on("links.id = place_links.link_id");
        where = where.and("place_links.place_id = ?", placeId);
    }
}

DSL.using(conn)
   .selectFrom(from)
   .where(where)
   .orderBy(field("links.score"))
   .limit(1)
   .fetch();