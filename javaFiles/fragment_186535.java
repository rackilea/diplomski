Iterator<Fruit> it = fruits.iterator();
while(it.hasNext()) {
    if(it.next().ID == fruitID) {
        it.remove();
        break;
    }
}