spring:
  cloud:
    config:
      username: ${my.stored.files.username}
      password: ${my.stored.files.password}
      label: ${spring.cloud.find.label}
      uri: ${spring.cloud.config.uri}
      enabled: false
      failFast: true