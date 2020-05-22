Session session = factory.openSession();
Query query = session
    .createQuery("FROM HealthLog "
        + "WHERE rtc >= :rtcL and rtc < :rtcG and siteId = :siteId "
        + "ORDER BY rtc DESC");
query.setParameter("rtcL", fromDate);
query.setParameter("rtcG", toDate);
query.setParameter("siteId", siteId);
query.setFirstResult(0);
query.setMaxResults(recordLimit);
List<HealthLog> res = query.list();
session.close();

Collections.sort(res, new Comparator<HealthLog>() {
  public int compare(HealthLog o1, HealthLog o2) {
    return o1.getRtc().compareTo(o2.getRtc());
  }
});