public List<Thingy> showThingies(int itemsPerPage, int pageOffest){
    // ..
    query.setMaxResults(itemsPerPage);
    query.setFirstResult(itemsPerPage * pageOffset);
    // ..
}