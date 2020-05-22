'
#
# Set this to true to enable auto deploy of layout templates, portlets, and
# themes.
#
auto.deploy.enabled=true

#
# Set the directory to scan for layout templates, portlets, and themes to
# auto deploy.
#
auto.deploy.deploy.dir=${liferay.home}/deploy

#
# Set the directory where auto deployed WARs are copied to. The application
# server or servlet container must know to listen on that directory.
# Different containers have different hot deploy paths. For example, Tomcat
# listens on "${catalina.base}/webapps" whereas JBoss listens on
# "${jboss.server.home.dir}/deploy". Set a blank directory to automatically
# use the application server specific directory.
#
auto.deploy.dest.dir=
auto.deploy.default.dest.dir=../webapps
auto.deploy.geronimo.dest.dir=${org.apache.geronimo.home.dir}/deploy
auto.deploy.glassfish.dest.dir=${com.sun.aas.instanceRoot}/autodeploy
auto.deploy.jboss.dest.dir=${jboss.server.home.dir}/deploy
auto.deploy.jetty.dest.dir=${jetty.home}/webapps
auto.deploy.jonas.dest.dir=${jonas.base}/deploy
auto.deploy.resin.dest.dir=${resin.home}/webapps
auto.deploy.tomcat.dest.dir=${catalina.base}/webapps
auto.deploy.weblogic.dest.dir=${env.DOMAIN_HOME}/autodeploy