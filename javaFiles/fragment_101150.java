group 'myapp'
version '1.0-SNAPSHOT'

apply plugin: 'java'
sourceCompatibility = 1.8

repositories {
  jcenter()
}

dependencies {
  compile group: 'org.apache.flink', name: 'flink-streaming-java_2.11', version: '1.8.0'
  compile group: 'org.apache.flink', name: 'flink-java', version: '1.8.0'
  compile group: 'org.apache.flink', name: 'flink-clients_2.11', version: '1.8.0'
  compile group: 'org.apache.flink', name: 'flink-avro', version: '1.8.0'
  compile group: 'org.apache.flink', name: 'flink-core', version: '1.8.0'
  compile group: 'org.apache.flink', name: 'flink-connector-kafka_2.12', version: '1.8.0'

  compile group: 'com.google.code.gson', name: 'gson', version: '2.8.5'
}