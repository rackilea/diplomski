import sbt.complete.Parsers._
import myfolder.Foo

lazy val foo = inputKey[Unit]("Foo you.")

foo := {
  val args: Seq[String] = spaceDelimited("<arg>").parsed
  Foo.bar(args: _*)
}