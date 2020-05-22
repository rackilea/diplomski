private fun initializeJxBrowser(): Browser {
    if(ChromiumExtractor.create().shouldExtract(BrowserPreferences.getChromiumDir())) {
       val cl = URLClassLoader(arrayOf(
                URL("file:.../license.jar"),
                URL("file:.../jxbrowser-mac-6.6.jar"),
                URL("file:../jxbrowser-6.6.jar")
                ))

        cl.loadClass("com.teamdev.jxbrowser.chromium.BrowserContext")
          .getMethod("defaultContext")
          .invoke(null)
   }
   return Browser()