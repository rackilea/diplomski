package test

public class LicenseInfo {
  StringBuffer licenseInformation

  public LicenseInfo() {
    licenseInformation = new StringBuffer()
  }

  public void fetchLicenseInformation( Map<String,String> params, Map env ) {
    List<String> licenseList = fetchLicenses( params, env )
    println "List is $licenseList"
  }

  public List<String> fetchLicenses( Map<String,String> params, Map env ) {
    [ 'a', 'b', 'c' ]
  }
}