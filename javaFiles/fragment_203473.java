fun saveVersion() {
    val currentVersion = context.packageManager
                .getPackageInfo(context.packageName, 0)
                .run {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        longVersionCode
                    } else {
                        versionCode.toLong()
                    }
                }
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)
    sharedPreferences.edit().putLong("versionCode", currentVersion).apply()
 }

 fun getSavedVersion(): Long {
     val sharedPreferences: SharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)
     return sharedPreferences.getLong("versionCode", -1L)
 }