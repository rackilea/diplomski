FROM openjdk:8-jdk-alpine

ADD target/app.jar /jar/

VOLUME /tmp

EXPOSE 8080

ENV SPRINGPROFILES=prod

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "-Dserver.port=8080", "-Dserver.address=0.0.0.0", "/jar/app.jar", "--spring.profiles.active=${SPRINGPROFILES}"]