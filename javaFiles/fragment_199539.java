@SuppressWarnings("unchecked")
@Override
public List<FrameFactory> getFrameFactoryByActiveYN(Boolean activeYN) {
    String sql = sqlProperties.getProperty("getFrameFactoryByActiveYN");
    SQLQuery q = getSession().createSQLQuery(sql);
    q.addEntity(FrameFactory.class);
    q.setParameter("activeYN", activeYN == null ? "N" : activeYN ? "Y" : "N", StringType.INSTANCE);
    List<FrameFactory>frameFactorys = q.list();
    return frameFactorys;
}