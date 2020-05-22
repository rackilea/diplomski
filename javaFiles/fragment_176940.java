javadoc {
  inputs.property("moduleName", moduleName)
  doFirst {
    options.addStringOption('-module-path', classpath.asPath)
  }
}