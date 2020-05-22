ext {
    // The drivers we want to use
    drivers = ["firefox", "chrome", "phantomJs"]

    ext {
        groovyVersion = '2.3.6'
        gebVersion = '0.10.0'
        seleniumVersion = '2.43.1'
        chromeDriverVersion = '2.10'
        phantomJsVersion = '1.9.7'
    }
}

dependencies {
    // If using Spock, need to depend on geb-spock
    testCompile "org.gebish:geb-spock:$gebVersion"
    testCompile("org.spockframework:spock-core:0.7-groovy-2.0") {
        exclude group: "org.codehaus.groovy"
    }
    testCompile "org.codehaus.groovy:groovy-all:$groovyVersion"

    // Drivers
    testCompile "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
    testCompile "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
    testCompile("com.github.detro.ghostdriver:phantomjsdriver:1.1.0") {
        // phantomjs driver pulls in a different selenium version
        transitive = false
    }
}