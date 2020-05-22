task generateJniHeaders(type:Exec) {
    def classpath = sourceSets.main.output.classesDir
    def nativeIncludes = "src/native/include"                     
    commandLine "javah", "-d", nativeIncludes, "-classpath", classpath, "$mainClassName"

    dependsOn classes
}