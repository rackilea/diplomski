switch (tipretea) {
    case "red":
        hue = BitmapDescriptorFactory.HUE_RED;
        break;
    case "green":
        hue = BitmapDescriptorFactory.HUE_GREEN;
        break;
    default:
        //TODO Do something to catch the possibility of an unexpected value for tipretea (notify the user / send an error report, something like that).
}