tasks.withType(JavaCompile) {
    doFirst {
        if (sourceCompatibility == '1.6' && System.env.JDK6_HOME != null) {
            options.fork = true
            options.bootClasspath = "$System.env.JDK6_HOME/jre/lib/rt.jar"
            options.bootClasspath += "$File.pathSeparator$System.env.JDK6_HOME/jre/lib/jsse.jar"
            // use the line above as an example to add jce.jar 
            // and other specific JDK jars
        }
    }
}