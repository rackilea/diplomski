# Use java 8 on bare linux as our base image
FROM openjdk:8-jdk-alpine

# Accepting argument from mvn plugin
ARG JAR_FILE

# Set ENV mode
#ENV STAGE=default
ENV DOCKER=true

# Renaming Jar File
COPY ${JAR_FILE} app.jar

# Starting the application
CMD ["java", "-jar", "/app.jar"]
# For actual prod applications, profiles wrt application.properties are used, but for college project, its ok*(Ignoring for first time configuration)
# CMD ["java", "-Dspring.profiles.active=${STAGE}", "-Dserver.port=6262", "-jar", "/app.jar"]

# Assuming the application port to be 6262. Replace with the appropriate port.
EXPOSE 6262