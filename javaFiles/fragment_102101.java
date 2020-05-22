spring:
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate: 
      ddl-auto: create-drop
    properties:
      hibernate:
        show-sql: false  
        format_sql: true
        order_inserts: true
        order_updates: true
        jdbc:
          batch_size: 50
  h2:    
    console:
      enabled: false
      settings:
        trace: false
  batch:
    table-prefix: My_
    initializer:
      enabled: false

  datasource:
    url: jdbc:h2:mem:MYBASE;Mode=Oracle;
    platform: h2
    username: sa
    password:
    driverClassName: org.h2.Driver
    continue-on-error: true