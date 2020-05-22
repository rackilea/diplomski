val networkAvailability = cm.getNetworkCapabilities(cm.activeNetwork)
if(networkAvailability !=null && networkAvailability.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && networkAvailability.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED))
{
    //has network
    if (networkAvailability.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) { //wifi
    } else if (networkAvailability.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) { //cellular
    }
}