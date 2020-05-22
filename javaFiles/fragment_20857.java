public static Date setMaxMillis(Date day,Calendar cal) {
    cal.setTime(day);
    cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
    return cal.getTime();
}

Query query = new Query(where("id").is(filter.getId()));
Criteria criteria = Criteria.where("lastModified").gt(setMaxMillis(filter.getLastModified(),Calendar.getInstance()));
query.addCriteria(criteria);
return mongoTemplate.findOne(query, MyDocument.class);