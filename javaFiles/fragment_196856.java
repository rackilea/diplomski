tomcat::instance { 'tomcat8':
  catalina_base       => '/var/lib/tomcat8',
  install_from_source => true,
  package_ensure      => 'present',
  package_name        => 'tomcat8'
}