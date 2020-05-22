configurations{ xslt }

dependencies {
    xslt    'net.sf.saxon:saxon:8.7'
}
task generateReport << {
    File reportDir=new File("${projectDir}/HTML_Reports")
    if(reportDir.exists()){
        reportDir.deleteDir()
    }
    reportDir.mkdir()
    ant.xslt(in: "${testReportDir.absolutePath}/test/testng-results.xml",
             style: "${projectDir.absolutePath}/src/test/resources/xslt_config/emailablereport.xsl",
             out: "${reportDir.absolutePath}/index.html",
             classpath: configurations.xslt.asPath) {
            param(name: 'paramXSLT.environment', expression: "${env}")
        }