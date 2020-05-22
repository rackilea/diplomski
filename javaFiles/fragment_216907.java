// specific config for scala projects
configure(scalaProjects) {
    apply plugin: 'scala'

    // this little hack zeroes out the java source directories
    // so that the scala plugin can handle them
    sourceSets.main.scala.srcDir "src/main/java"
    sourceSets.main.java.srcDirs = []
    sourceSets.test.scala.srcDir "src/test/java"
    sourceSets.test.java.srcDirs = []


    // define a configuration for scala compiler plugins
    // the transitive=false means that the plugin won't show up
    // as a dependency in the final output
    configurations {
        scalaCompilerPlugins { transitive = false }
    }

    // this plugin will transform .scala files into javadoc'able .java files
    // so that the regular javadoc will run
    dependencies {
        scalaCompilerPlugins  group: 'com.typesafe.genjavadoc', name: 'genjavadoc-plugin_2.10.2', version:'0.5'
        compile group: 'org.scala-lang', name: 'scala-library', version:'2.10.2'
        compile group: 'org.scala-lang', name: 'scala-compiler', version:'2.10.2'
    }

    // this string contains theplugin paths that get passed to the compiler
    def pluginPaths = configurations.scalaCompilerPlugins.files.collect { "\"-Xplugin:${it.path}\"" }

    // this is the genjavadoc arguments - effectively it tells the plugin where to put the generated code
    compileScala.scalaCompileOptions.additionalParameters = pluginPaths + "\"-P:genjavadoc:out=$buildDir/genjavadoc\""

    task javaDocs(type : Javadoc) {
        source = fileTree("src/main/java").include("*.java") + fileTree("$buildDir/genjavadoc")
        options.addStringOption("-quiet")
    }

}