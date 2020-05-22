applications:
  - name: rule_runtime 
    buildpack: java_buildpack
    path: target/com.sap.brms.web.app.0.0.1-SNAPSHOT.war
    env:
      TARGET_RUNTIME: tomcat
      destinations: [  {"name":"bpmrulesrepository", "url":"https://example.com"}]