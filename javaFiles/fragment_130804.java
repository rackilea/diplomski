// We need at least Java 7.
initialize := {
  val _ = initialize.value // Needed to run previous initialization.
  assert(scala.util.Properties.isJavaAtLeast("1.7"), "My project requires Java 7 or later")
}

// Configure Java compiler appropriately.
javacOptions ++= Seq(
  "-source", "1.7",
  "-target", "1.7",
  "-bootclasspath", "C:\\jdk1.7.0\\lib\\rt.jar"
)