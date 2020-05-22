# Default DB parameter definitions for the URL parameters in the spring.datasource.url property below
database:
  host: localhost
  port: 3306
  schema: subscriptions
  username: root
  password: root
  autoconnect:
    maxReconnects: 3
    initialTimeout: 2
  timeout:
    connectTimeout: 0
    socketTimeout: 0
  failover:
    host: localhost 
    port: 3306
    queriesBeforeRetryMaster: 50
    secondsBeforeRetryMaster: 30
  properties: useTimezone=true&serverTimezone=UTC&useLegacyDatetimeCode=false&failOverReadOnly=false&autoReconnect=true&maxReconnects=${database.autoconnect.maxReconnects}&initialTimeout=${database.autoconnect.initialTimeout}&connectTimeout=${database.timeout.connectTimeout}&socketTimeout=${database.timeout.socketTimeout}&queriesBeforeRetryMaster=${database.failover.queriesBeforeRetryMaster}&secondsBeforeRetryMaster=${database.failover.secondsBeforeRetryMaster}

spring:
  datasource:
    driverClassName: com.mysql.jdbc.Driver
    url: jdbc:mysql://${database.host}:${database.port},${database.failover.host}:${database.failover.port}/${database.schema}?${database.properties}
    username: ${database.username}
    password: ${database.password}
    continueOnError: true
    initialize: false
    initialSize: 0
    timeBetweenEvictionRunsMillis: 5000
    minEvictableIdleTimeMillis: 5000
    removeAbandonedTimeout: 60
    removeAbandoned: true
    minIdle: 0

  jpa:
    show-sql: true
    hibernate:
      ddl-auto: none
      naming_strategy: org.hibernate.cfg.DefaultNamingStrategy
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL5Dialect
        hbm2ddl:
          auto: none
        temp:
          use_jdbc_metadata_defaults: false