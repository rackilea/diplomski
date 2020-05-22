# Embedded database configuration
# The embedded database file is one level above the Server folder (ie directly within the parent project)
# we use the auto server mode to be able to use the database simultaneously in the indexer and the server
spring.datasource.url=jdbc:h2:file:../myLocalDB;AUTO_SERVER=TRUE
spring.datasource.username=myName
# This parameter helped me discover that SpringBoot was not targetting the right table name.
spring.jpa.hibernate.ddl-auto=validate