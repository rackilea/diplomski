@Transactional(readOnly = true, propagation = Propagation.REQUIRED)

public DeviceProfileAttribute getRandomDeviceProfileAttribute(Category category, Platform platform) {

Query q = em.createQuery(
        "SELECT d FROM DeviceProfileAttribute d " +
        "WHERE d.tenantAttribute.attribute.category=:category AND " +
        "d.tenantAttribute.attribute.platform=:platform "
);
q.setParameter("category", category);
q.setParameter("platform", platform);
if (q.getResultList().isEmpty()) {
    return null;
} else {
    return (DeviceProfileAttribute) q.getResultList().get( new Random().nextInt(q.getResultList().size()));;
}

}