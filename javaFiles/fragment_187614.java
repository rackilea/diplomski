public class LocalSessionFactoryBeanMod extends LocalSessionFactoryBean {

    private String cacheRegion;

    public String getCacheRegion() {
        return this.cacheRegion;
    }

    public void setCacheRegion(String cacheRegion) {
        this.cacheRegion = cacheRegion;
        getHibernateProperties().put("hibernate.cache.region_prefix", cacheRegion);
    }

    @Override
    public void setHibernateProperties(Properties hibernateProperties) {
        if (getHibernateProperties().isEmpty()) {
            super.setHibernateProperties(hibernateProperties);
        } else {
            getHibernateProperties().putAll(hibernateProperties);
        }
    }
}