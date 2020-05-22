public DVD add(String titlez, String categoryz, String runTimez, String yearz, String pricez) {
    for (DVD dvd : arrayList) {
        if(dvd.getTitle().equals(titlez)){
            return dvd;
        }
    }
    DVD dvd1 = new DVD (titlez, categoryz, runTimez, yearz, pricez);
    arraylist.add(dvd1);

    return null;
}