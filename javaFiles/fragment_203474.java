if (getSavedVersion() == -1L) {
   saveVersion()
} else {
   if (currentVersion > getVersion()) {
       // Then you must clear data
       clearApplicationData()
   }
}