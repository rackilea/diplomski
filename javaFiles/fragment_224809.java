Object[] items = new Object[vertical.size() + horizontal.size() + ad.size()];

for (VerticalItem item : vertical) {
    items[item.position] = item;
}

for (HorizontalItem item : horizontal) {
    items[item.position] = item;
}

for (AdItem item : ad) {
    items[item.position] = item;
}