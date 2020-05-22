spring.jpa.hibernate.ddl-auto=update

# Replace with your connection string
spring.datasource.url=jdbc:mysql://localhost:3306/myapp
spring.datasource.connectionProperties=useUnicode=true;characterEncoding=utf-8;

# Replace with your credentials
spring.datasource.username=root
spring.datasource.password=root

#spring.datasource.test-while-idle=true

# Keep the connection alive if idle for a long time (needed in production)
spring.datasource.testWhileIdle = true
spring.datasource.validationQuery = SELECT 1

spring.datasource.test-on-borrow=true
spring.datasource.connection-test-query=SELECT 1
spring.datasource.tomcat.validation-interval=0
# Number of ms to wait before throwing an exception if no connection is available.
spring.datasource.tomcat.max-wait=10000

# Validate the connection before borrowing it from the pool.
spring.datasource.tomcat.test-on-borrow=true

#spring.datasource.driverClassName=com.mysql.jdbc.Driver
#spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
#spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect