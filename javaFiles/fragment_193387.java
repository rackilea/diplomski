import com.trueaccord.scalapb.{ScalaPbPlugin => PB}

name  :=  "proto-buf-test"

scalaVersion := "2.10.5"

autoCompilerPlugins in Global := true

lazy val root = project.in(file(".")).settings(PB.protobufSettings:_*).settings(
     PB.javaConversions in PB.protobufConfig := true
)