includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsCreateArtifacts")
includeTargets << new File("$userInterfacePluginDir/scripts/_GrailsGenerateService.groovy")

target ('default': "Generates the service for a specified domain class") {
depends(checkVersion, parseArguments, packageApp)
promptForName(type: "Domain Class")
generateForName = argsMap["params"][0]
generateServiceForOne()
}