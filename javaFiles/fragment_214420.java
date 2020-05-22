//generate eclipse .project, .classpath, .factorypath files
//References: https://github.com/mkarneim/pojobuilder/wiki/Enabling-PojoBuilder-for-Eclipse-Using-Gradle
apply plugin: 'eclipse'

ext { 
    eclipseAptFolder = '.apt_generated'
    eclipseSettingsDir = file('.settings')
}

configurations {
    codeGeneration
}    

dependencies {
    codeGeneration 'com.squareup.dagger:dagger-compiler:1.2.2'
    compile 'com.squareup.dagger:dagger:1.2.2'
}
compileJava.classpath += configurations.codeGeneration

eclipse {
    jdt.file.withProperties { 
        it['org.eclipse.jdt.core.compiler.processAnnotations'] = 'enabled'
    }
}

tasks.eclipseJdt {
    doFirst {
        def aptPrefs = file("${eclipseSettingsDir}/org.eclipse.jdt.apt.core.prefs")
        aptPrefs.parentFile.mkdirs()

        aptPrefs.text = """\
    eclipse.preferences.version=1
    org.eclipse.jdt.apt.aptEnabled=true
    org.eclipse.jdt.apt.genSrcDir=${eclipseAptFolder}
    org.eclipse.jdt.apt.reconcileEnabled=true
    """.stripIndent()

        file('.factorypath').withWriter {
            new groovy.xml.MarkupBuilder(it).'factorypath' {
                project.configurations.codeGeneration.each { dep->
                    factorypathentry(
                        kind:'EXTJAR',
                        id:dep.absolutePath,
                        enabled:true,
                        runInBatchMode:false
                    )
                }
            }
        }
    }
}