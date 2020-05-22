plugins {
  id "com.google.osdetector" version "1.3.1"
}

repositories {
  jcenter()
}

configurations {
  protoc    
}

dependencies {
  protoc "com.google.protobuf:protoc:3.1.0:${osdetector.classifier}@exe"
}

task executeProtoc(type: Exec) {
  executable configurations.protoc.singleFile
  args "--proto_path", "${projectDir}/src/main/proto"
  args "--java_out", "src/gen/main/java"
  args protoFiles
}