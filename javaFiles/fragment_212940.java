void processChilds(Item child) {
List<Item> childs = selectChilds(child);
    for(Item i: childs) {
       //do smth
       processChilds(i);
    }
}