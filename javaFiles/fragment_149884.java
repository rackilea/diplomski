ext.isTask = { name -> return project.gradle.startParameter.taskNames.contains(name) }

/**
 * Heuristic function allowing to build process guess if annotation processor run is necessary
 * Annotation processors will not be called during build task if this function returns FALSE
 */
ext.isApInvalidated = { -> return hasAnyFileRelatedToApChanged() }

dependencies {
  if (isTask("buildWithAP") || isApInvalidated()) {
    println "Going to run annotation processors ..."
    apt "com.querydsl:querydsl-apt:$queryDslVersion:jpa"
  ...
  } else {
    // just add generated classes to the classpath
    // must be in else branch or multiple AP calls will collide!
  sourceSets.main.java.srcDirs += projectDir.absolutePath + "/build/generated/apt"
  }