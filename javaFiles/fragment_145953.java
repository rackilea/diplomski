jib {
  ...
  to {
    image = 'rishabh9/jib-demo'
    project.afterEvaluate { // <-- so we evaluate version after it has been set
      tags = [version]
    }
  }
  ...
}