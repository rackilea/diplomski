plugins {
    id 'application'
}

application {
    applicationDefaultJvmArgs = ['-Xmx512m', '-XX:MaxPermSize=512m', '-Dinm.testmode=true', '-Dfile.encoding=UTF-8', '-Xdebug','-Xrunjdwp:transport=dt_socket,server=y,address=7979,suspend=n']
}