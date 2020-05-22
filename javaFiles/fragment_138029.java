# Unpack the distribution
[~]$ unzip jetty-distribution-9.2.3.v20140905

# Make a {jetty.base} directory to house your configuration
[~]$ mkdir myappbase
[~]$ cd myappbase

# Since this is a new {jetty.base}, lets initialize it
[myappbase]$ java -jar ../jetty-distribution-9.2.3.v20140905/start.jar \
  --add-to-start=http,logging,deploy,jsp,ext,resources
INFO: http            initialised in ${jetty.base}/start.ini (appended)
INFO: server          initialised in ${jetty.base}/start.ini (appended)
INFO: logging         initialised in ${jetty.base}/start.ini (appended)
MKDIR: ${jetty.base}/logs
INFO: deploy          initialised in ${jetty.base}/start.ini (appended)
MKDIR: ${jetty.base}/webapps
...(snip)...
MKDIR: ${jetty.base}/lib
MKDIR: ${jetty.base}/lib/ext
INFO: resources       initialised in ${jetty.base}/start.ini (appended)
MKDIR: ${jetty.base}/resources

# Lets see what we have now
[myappbase]$ ls -F
lib/  logs/  resources/  start.ini  webapps/

# Copy your webapp into place
[myappbase]$ cp ~/Projects/mywebapp.war webapps/

# Run Jetty
[myappbase]$ java -jar ../jetty-distribution-9.2.3.v20140905/start.jar