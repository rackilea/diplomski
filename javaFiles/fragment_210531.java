FROM tomcat:7-jre8-alpine
LABEL maintainer="myemail@myemail.mytld"
EXPOSE 8080
ARG WAR_FILE=target/myappbuilded-0.0.1-SNAPSHOT.war
ARG TOMCAT_USERS_FILE=tomcat-users.xml
ADD ${WAR_FILE} /usr/local/tomcat/webapps/myappbuilded.war
ADD ${TOMCAT_USERS_FILE} /usr/local/tomcat/conf
CMD ["catalina.sh", "run"]