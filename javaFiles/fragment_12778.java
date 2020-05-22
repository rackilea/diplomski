###################################
### JOBS DATASOURCE PROPERTIES. ###
###################################
## URL used to connect to the jobs database.
spring.secondDatasource.url=jdbc:h2:mem:jobsdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
## Driver class used to connect to the jobs database (it will depend on datasource).
spring.secondDatasource.driver-class-Name=org.h2.Driver
## User name 
spring.secondDatasource.username=xxx
## Password 
spring.secondDatasource.password=xxx
## Datasource configuration for jobs database.
spring.jpa.hibernate.ddl-auto=create-drop
spring.secondDatasource.initialize=true
spring.secondDatasource.test-on-borrow=true
spring.secondDatasource.validation-query=select 1