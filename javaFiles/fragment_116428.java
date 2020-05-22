URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?" + address + "&sensor=false");
try {
    output = new Scanner(url.openStream()).useDelimiter("\\A").next());
} catch (java.util.NoSuchElementException e) {
    //empty result
}