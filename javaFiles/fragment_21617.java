public DVD remove(String title) {
    for (DVD dvd : arrayList) {
        if (dvd.getTitle().equals(title)) {
            arrayList.remove(dvd);
            return dvd;
        }
    }
    return null;
}