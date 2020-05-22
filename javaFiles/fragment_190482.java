// tell sbt (and by extension IDEA) that there is source code in target/generated_sources
managedSourceDirectories in Compile += baseDirectory.value / "target" / "generated_sources"
// before compilation happens, create the target/generated_sources directory
compile in Compile <<= (compile in Compile).dependsOn(Def.task({
  (baseDirectory.value / "target" / "generated_sources").mkdirs()
}))
// tell the java compiler to output generated source files to target/generated_sources
javacOptions in Compile ++= Seq("-s", "target/generated_sources")