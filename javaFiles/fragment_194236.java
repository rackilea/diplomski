FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV arg1
ENV arg2
ENV arg3
ADD target/myProject-1.0-SNAPSHOT.jar myProject-1.0-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /myProject-1.0-SNAPSHOT.jar ${arg1} ${arg2} ${arg3}" ]