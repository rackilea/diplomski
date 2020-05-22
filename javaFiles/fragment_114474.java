StringBuilder sb = new StringBuilder();
sb.append("SELECT p FROM Person p");

if (<name or yearBirth is not null and empty>)
    sb.append(" WHERE");
if (<name is not null and not empty>) {
    sb.append(" p.name = :name");
    if (<yearBirth is not null and not empty>)
        sb.append(" AND");
}
if (<yearBirth is not null and not empty>)
    sb.append(" p.yearBirth = :yearBirth");

//then create query
Query query = em.createQuery(sb.toString());

//then set query param
if (<name is not null and not empty>)
    query.setParameter("name", name);
if (<yearBirth is not null and not empty>)
    query.setParameter("yearBirth", Short.parseShort(yearBirth));

//Now your query is ready to use