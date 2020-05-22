class LocationDetector(val context: Context) {

    val fusedLocationClient: FusedLocationProviderClient = FusedLocationProviderClient(context)
    var locationListener: LocationListener? = null

    interface LocationListener {
        fun locationFound(location: Location)
        fun locationNotFound(reason: String)
    }

    fun detectLocation() {

        //create request
        val locationRequest = LocationRequest()
        locationRequest.interval = 0L

        // check for permission
        val permissionResult = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION)

        // if have permission, try to get location within 10 seconds
        if (permissionResult == android.content.pm.PackageManager.PERMISSION_GRANTED) {
            val timer = Timer()

            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    fusedLocationClient.removeLocationUpdates(this)
                    timer.cancel()
                    // return location
                    locationListener?.locationFound(locationResult.locations.first())
                }
            }

            timer.schedule(timerTask {
                fusedLocationClient.removeLocationUpdates(locationCallback)
                locationListener?.locationNotFound("Timeout")
            }, 10 * 1000) //10 seconds

            // make request
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
        } else {
            // if no permission
            locationListener?.locationNotFound("No permission given")
        }
    }