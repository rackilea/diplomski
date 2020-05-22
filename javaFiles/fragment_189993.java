shadowJar {
 from file("${buildDir}/libs/launcher-${version}-obf.jar")
 dependencies {
   exclude(dependency('org.projectlombok:lombok'))
 }
}