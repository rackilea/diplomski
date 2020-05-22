sourceSets {
  test {
    resources {
      srcDir 'src/test/resources'
      include 'src/main/resources/xslt.sec/sec_report.xslt'
    }
  }
}