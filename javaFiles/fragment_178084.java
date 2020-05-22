filter { parking ->
    parking.city === pr.city &&
    parking.price.toDouble() >= pr.priceFrom &&
    parking.price.toDouble() <= pr.priceTo &&
    !parking.daysBusy.contains(daysSet.split("|").toString())
}