this.items = new ArrayList<>();

if (listVertical.size() > 0) {
    items.add(listVertical.remove(0));
}

if (listHorizontal.size() > 0) {
    items.add(listHorizontal.remove(0));
}

while (listVertical.size() > 0 || listAd.size() > 0) {    
    if (listAd.size() > 0) {
        items.add(listAd.remove(0));
    }

    int count = 5;

    while (count > 0 && listVertical.size() > 0) {
        items.add(listVertical.remove(0));
    }
}