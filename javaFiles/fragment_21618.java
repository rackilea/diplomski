public DVD remove(String title) {
    DVD toRemove = null;
    for (DVD dvd : arrayList) {
        if (dvd.getTitle().equals(title)) {
            toRemove = dvd;
            break;
        }
    }
    if (toRemove != null) {
        arrayList.remove(toRemove);
    }
    return toRemove;
}