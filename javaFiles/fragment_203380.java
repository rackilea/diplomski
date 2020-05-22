ListIterator<Element> bundleList = indieGala.select("section.games_bundle_box2")
    .get(0)
    .select("ul.unlock > li")
    .listIterator();

assert Iterators.size(bundleList) == 5;