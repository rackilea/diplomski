buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        // SvnKit from https://gist.github.com/thombergs/9279728
        classpath group: 'org.tmatesoft.svnkit', name: 'svnkit', version: '1.8.14'
    }
}


// SvnKit get svn revision
import org.tmatesoft.svn.core.wc.*
def getSvnRevision(){
        ISVNOptions options = SVNWCUtil.createDefaultOptions(true);
        SVNClientManager clientManager = SVNClientManager.newInstance(options);
        SVNStatusClient statusClient = clientManager.getStatusClient();
        SVNStatus status = statusClient.doStatus(projectDir, false);
        SVNRevision revision = status.getRevision();
        return revision.getNumber();
        }




// extract from file
def extractfromfile(source, pattern) {
  (source.text =~ pattern) [0]
}

// extract from string
def extract(source, pattern) {
  (source =~ pattern) [0]
}

// replace
def ReplaceText(source, targetText, replaceText){
  source.write(source.text.replaceAll(targetText, replaceText))
}


def updateApplicationXml() {
  def applicationXml = new File('config/META-INF/application.xml')
  def settingsGradle = new File('settings.gradle')
  def prjRegex = "'(.*)'"
  def prj =  settingsGradle.text.split(',')



  //for every project
  List<String> list = new ArrayList<String>(Arrays.asList(prj))

  for(String item: list){

    def prjPath = extract(item, prjRegex)[1]
    //println prjPath


    //search for build.gradle
    def buildGradle = new File(prjPath+'/build.gradle')
    def basenamePattern = "baseName = '(.*)'"
    def versionPattern = "version = '(.*)'"

    //extract basename
    def basename
    try {
      basename = extractfromfile(buildGradle, basenamePattern)
    } catch (Exception ex){
        continue
    }

    //extract version
    def version
    try {
      version = extractfromfile(buildGradle, versionPattern)
    } catch (Exception ex){
        continue
    }

    def warname = basename[1] + "-" + version[1] + getSvnRevision()

  //  println basename[1]
  //  println version[1]
  //  println warname
  //  println applicationXml


    // do the replace
    ReplaceText(applicationXml, "<web-uri>"+basename[1]+"(.*).war</web-uri>", "<web-uri>"+warname+".war</web-uri>")

  }
}

apply plugin: 'ear'

dependencies {
    deploy project(path: ':WarA/trunk', configuration: 'archives')
    deploy project(path: ':WarB/trunk', configuration: 'archives')

}



ear {
    updateApplicationXml()
    appDirName 'config'
}