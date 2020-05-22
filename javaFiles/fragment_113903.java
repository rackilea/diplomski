apply plugin: 'java'

buildscript {
   dependencies {
      classpath files("libs/some.library.jar")
   }
}

task A << {
    def obj = new some.library.TestClass()
    obj.doSomething()
}