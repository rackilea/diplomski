public Long searchCount() {
    String sql = getQueryString("Airframe").replace("#SELECTOR#", "count(*)");
    return (Long) session.createSQLQuery(sql, args...).uniqueResult();
}

@SuppressWarnings("unchecked")
public List<AirframeBean> getAirframeBeans() {
    String sql = getQueryString("Airframe").replace("#SELECTOR#", "a");
    return session.createSQLQuery(sql, args...).list();
}

private String getQueryString(String namedQuery) {
    return session.getNamedQuery(namedQuery).getQueryString();
}