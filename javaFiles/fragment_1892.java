String configurationResourceName = null;
if ( properties != null ) {
    configurationResourceName = (String) properties.get( NET_SF_EHCACHE_CONFIGURATION_RESOURCE_NAME );
}
if ( configurationResourceName == null || configurationResourceName.length() == 0 ) {
    final Configuration configuration = ConfigurationFactory.parseConfiguration();
    manager = new CacheManager( configuration );
}
else {
    final URL url = loadResource( configurationResourceName );
    final Configuration configuration = HibernateEhcacheUtils.loadAndCorrectConfiguration( url );
    manager = new CacheManager( configuration );
}