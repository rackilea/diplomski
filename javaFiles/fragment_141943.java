compile('org.apache.hadoop:hadoop-core:1.2.1')

compile ('org.apache.hive:hive-jdbc:0.13.1'){
    exclude group: 'org.eclipse.jetty.aggregate', module: '*'
    exclude group: "org.slf4j", module: "slf4j-log4j12"
    exclude group: "log4j", module: "log4j"    }

compile ('org.apache.hadoop:hadoop-common:3.0.0'){
    exclude group: "org.slf4j", module: "slf4j-log4j12"
    exclude group: "log4j", module: "log4j"
}