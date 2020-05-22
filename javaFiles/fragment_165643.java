apply plugin: 'application'
apply plugin: 'com.github.johnrengelman.shadow'

mainClassName = 'com.example.Main'

jar {
  manifest {
    attributes 'Main-Class': 'com.example.Main'
  }
}

publishing {
  publications {
    nebulaIvy(IvyPublication) {
      artifact(tasks.findByName('createJarExe').outputs.getFiles().getSingleFile()) {
        classifier '_-jdk8'
        extension 'exe'
        type 'exe'
      }
    }
  }
}

task createJarExe(dependsOn: installShadowDist) {
  final outputFile = file("${buildDir}/install/${project.name}-shadow/bin/${project.name}-${project.version}.exe")

  doLast {
    outputFile.text = '#!/bin/bash\n'
    outputFile.append('exec java -jar "$0" "$@"')
    outputFile.append(inputs.files.first().readBytes())
    outputFile.setExecutable(true)
  }

  inputs.files "${tasks.findByName('installShadowDist').outputs.getFiles().getSingleFile()}/lib/${project.name}-${project.version}-all.jar"
  outputs.file outputFile
  doFirst {
    mkdir outputFile.getParent()
  }
}

// wire the dependencies
tasks.whenTaskAdded { task ->
  if (task.name == 'publishNebulaIvyPublicationToDistIvyRepository') {
    task.dependsOn('createJarExe')
  }
}