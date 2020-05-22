apply plugin: 'java' // adds 'test' task

test {

  // set JVM arguments for the test JVM(s)
  jvmArgs '-XX:MaxPermSize=256m'

}