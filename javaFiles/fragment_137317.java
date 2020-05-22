custom:
 max-active: 10 
spring:
datasources:
  datasource1:
    url: jdbc:mysql://url:port1
    max-active: ${custom.max-active}
  datasource2:
    url: jdbc:mysql://url:port2
    max-active: ${custom.max-active}