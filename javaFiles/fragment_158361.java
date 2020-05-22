configurations.all {
  resolutionStrategy {

    // add a dependency resolve rule
    eachDependency { DependencyResolveDetails details ->
      //specifying a fixed version for all libraries with 'org.springframework' group
      if (details.requested.group == 'org.springframework') {
          details.useVersion'4.1.3.RELEASE'
      }
    }
  }
}