ant.schemagen(srcdir: new File('src/main/java'), destdir: schemaTargetDir, includeAntRuntime:'false') { 
    classpath { 
        pathElement(path: configurations.jaxb.asPath ) 
    } 
} 
dependencies { 
    compile group: 'commons-collections', name: 'commons-collections', version: '3.2' 
    testCompile group: 'junit', name: 'junit', version: '4.+' 
    jaxb ( 
          'com.sun.xml.bind:jaxb-xjc:2.1.6', 
          'org.apache.avro:avro-tools:1.7.5', 
          'org.apache.avro:avro:1.7.5' 
          ) 
}