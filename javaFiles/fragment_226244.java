---
applications:
- name: testskipapi
  memory: 1G
  instances: 1
  path: build/libs/skipcode-0.0.1-SNAPSHOT.jar
  buildpack: https://github.com/cloudfoundry/java-buildpack.git
env:
  JBP_CONFIG_OPEN_JDK_JRE: '{ jre: { version: 1.8.0_+ } }'