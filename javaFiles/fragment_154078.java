android.libraryVariants.all { variant ->
  def name = variant.buildType.name
  if (name.equals(com.android.builder.core.BuilderConstants.DEBUG)) {
    return; // Skip debug builds.
  }
  def task = project.tasks.create "jar${name.capitalize()}", Jar
  task.dependsOn variant.javaCompile
  task.from variant.javaCompile.destinationDir
  artifacts.add('archives', task);
}