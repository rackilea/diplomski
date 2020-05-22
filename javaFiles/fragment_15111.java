FROM openjdk:8-jdk-alpine

ADD target/app.jar /jar/

VOLUME /tmp

EXPOSE 8080

ENV SPRINGPROFILES=prod

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=${SPRINGPROFILES}","-jar", "-Dserver.port=8080", "-Dserver.address=0.0.0.0", "/jar/app.jar"]