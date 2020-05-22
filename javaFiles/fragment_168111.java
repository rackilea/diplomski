ps = conn.prepareStatement("SELECT CT.NAME AS COMPONENT_TYPE, COUNT(1) AS CNT FROM COMPONENTSTATS CS, COMPONENTTYPE CT "
    + " WHERE CS.COMPONENTTYPEID = CT.COMPONENTTYPEID AND CT.COMPONENTTYPEID IN ( "
    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " //  10
    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " //  20
    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " //  30
    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) " //  40
    + " GROUP BY CT.NAME ORDER BY CT.NAME");