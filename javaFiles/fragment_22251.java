float hue = 0;
switch (tipretea) {
    case "red":
        hue = BitmapDescriptorFactory.HUE_RED;
        break;
    case "green":
        hue = BitmapDescriptorFactory.HUE_GREEN;
        break;
}
markeradd(
    id,
    bmp,
    pozastring,
    adresa,
    denumire,
    tipretea,
    latitude + "",
    longitude + "",
    latlng,
    BitmapDescriptorFactory
    .defaultMarker(hue));