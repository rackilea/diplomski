StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
    googlePlacesUrl.append("location=" + latitude + "," + longitude);
    googlePlacesUrl.append("&radius=10000");
    googlePlacesUrl.append("&type=" + "art_gallery");
    googlePlacesUrl.append("&sensor=true");
    googlePlacesUrl.append("&key=" + "AIzaSyCx8-ZK6m5FTgEoTaSRaUuALV-5Vnz1Co4");
    Log.d("getUrl", googlePlacesUrl.toString());
    return (googlePlacesUrl.toString());