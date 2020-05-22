developerBuild << {
  exec{
    commandLine = ['cmd', '/c', 'net', 'stop', 'Foo']
    ignoreExitValue = true
  }
}