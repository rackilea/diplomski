public List list(String id, Boolean includePrivate, Boolean includePublic) {
    boolean inclPrivate = (includePrivate != null && includePrivate);
    boolean inclPublic = (includePublic != null && includePublic);
    List result = new ArrayList();
    if (inclPublic || ! inclPrivate)
        result.addAll(getAllPublic());
    if (inclPrivate && id != null)
        result.addAll(getPrivateMembers(id));
    else if (inclPrivate || ! inclPublic)
        result.addAll(getAllPrivate());
    return result;
}