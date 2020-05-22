ArrayList<NewsfeedItem> itemsPos = new ArrayList<>();
itemsPos.addAll(listVertical);
itemsPos.addAll(listHorizontal);
itemsPos.addAll(adList);

Collections.sort(items, new Comparator<NewsfeedItem>() {
    @Override
    public int compare(NewsfeedItem o1, NewsfeedItem o2) {
        return Integer.compare(o1.getPosition(),o2.getPosition());
    }
});