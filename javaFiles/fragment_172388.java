// put config files in src/dist/config

dependencies {
  runtime files('src/dist/config')
}

startScripts {
  classpath += files('src/dist/XxxAPlaceHolderForAConfigxxX')
  doLast {
    def windowsScriptFile = file getWindowsScript()
    def unixScriptFile    = file getUnixScript()
    windowsScriptFile.text = windowsScriptFile.text.replace('%APP_HOME%\\lib\\XxxAPlaceHolderForAConfigxxX', '%APP_HOME%\\config')
    unixScriptFile.text  = unixScriptFile.text.replace('$APP_HOME/lib/XxxAPlaceHolderForAConfigxxX', '$APP_HOME/config')
  }
}