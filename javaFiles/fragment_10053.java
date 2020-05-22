configurations.all {
    resolutionStrategy.eachDependency { DependencyResolveDetails details ->
        if (details.requested.name == '${sikulix.libs}') {
            def os = org.gradle.internal.os.OperatingSystem.current()
            def targetName
            if (os.isWindows()) {
                targetName = 'sikulixlibswin'
            } else if (os.isUnix()) {
                targetName = 'sikulixlibslux'
            } else if (os.isMacOsX()) {
                targetName = 'sikulixlibsmac'
            } else {
                throw new GradleException("Unknow operating system for determining the sikulix distribution")
            }
            details.useTarget group: details.requested.group, name: targetName, version: details.requested.version
            details.because 'The Maven dependency is relying on profiles to select the correct module name for the current operating system'
        }
    }
}