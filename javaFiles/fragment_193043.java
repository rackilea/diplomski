project.dependencies {
    compile 'com.github.jd-alexander:flender-runtime:1.0'
    // TODO this should come transitively
    compile 'org.aspectj:aspectjrt:1.8.5'
}

variants.all { variant ->

    variant.dex.doFirst {
        String[] args = [
                "-showWeaveInfo",
                "-1.5",
                "-inpath", javaCompile.destinationDir.toString(),
                "-aspectpath", javaCompile.classpath.asPath,
                "-d", javaCompile.destinationDir.toString(),
                "-classpath", javaCompile.classpath.asPath,
                "-bootclasspath", project.android.bootClasspath.join(File.pathSeparator)
        ]
        log.debug "ajc args: " + Arrays.toString(args)

        MessageHandler handler = new MessageHandler(true);
        new Main().run(args, handler);