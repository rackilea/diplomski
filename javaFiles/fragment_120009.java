# Install maven and copy project for compilation
FROM maven:latest as builder

COPY pom.xml /usr/local/pom.xml
COPY server /usr/local/server
COPY client /usr/local/client
WORKDIR /usr/local/

RUN mvn clean install


FROM openjdk:8
ENV WKHTML_VERSION 0.12.4
# Builds the wkhtmltopdf download URL based on version numbers above
ENV DOWNLOAD_URL "https://github.com/wkhtmltopdf/wkhtmltopdf/releases/download/${WKHTML_VERSION}/wkhtmltox-${WKHTML_VERSION}_linux-generic-amd64.tar.xz"

RUN apt-get update && \
    apt-get install -y --no-install-recommends wget && \
    wget $DOWNLOAD_URL && \
    tar vxf wkhtmltox-${WKHTML_VERSION}_linux-generic-amd64.tar.xz && \
    cp wkhtmltox/bin/wk* /usr/local/bin/ && \
    cp wkhtmltox/lib/* /usr/local/lib/ && \
    rm wkhtmltox-${WKHTML_VERSION}_linux-generic-amd64.tar.xz

COPY   --from=builder /usr/local/redo/server/target/server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]