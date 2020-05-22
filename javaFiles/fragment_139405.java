protected String addLocationToUrl(String url){
    if(!url.endsWith("?"))
        url += "?";

    List<NameValuePair> params = new LinkedList<NameValuePair>();

    if (lat != 0.0 && lon != 0.0){
        params.add(new BasicNameValuePair("lat", String.valueOf(lat)));
        params.add(new BasicNameValuePair("lon", String.valueOf(lon)));
    }

    if (address != null && address.getPostalCode() != null)
        params.add(new BasicNameValuePair("postalCode", address.getPostalCode()));
    if (address != null && address.getCountryCode() != null)
        params.add(new BasicNameValuePair("country",address.getCountryCode()));

    params.add(new BasicNameValuePair("user", agent.uniqueId));

    String paramString = URLEncodedUtils.format(params, "utf-8");

    url += paramString;
    return url;
}