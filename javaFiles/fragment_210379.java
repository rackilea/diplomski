class MainActivity : AppCompatActivity(), LocationDetector.LocationListener {
    var isGPSRunning = false
    override fun locationFound(location: Location) {
   AppPreferencesSingleton(applicationContext).put(AppPreferencesSingleton.Key.latitude,location.latitude.toString())
    AppPreferencesSingleton(applicationContext).put(AppPreferencesSingleton.Key.longitude,location.longitude.toString())
}

override fun locationNotFound(reason: String) {
    when(isGPSEnabled()){
        true -> {
            println("Waiting for GPS fix")
        }
        false -> {
            if (!isGPSRunning) {
                isGPSRunning = true
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
            }
        }
    }
}

fun isGPSEnabled() = (getSystemService(Context.LOCATION_SERVICE) as LocationManager).isProviderEnabled(LocationManager.GPS_PROVIDER)