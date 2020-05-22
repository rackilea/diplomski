public void removeCustomObject(String customId) {
    objList.remove(findCustomObjectWithId(id));
}

private MCustomObject findCustomObjectWithId(int id) {
    for(MCustomObject custom : objList) {
        if (custom.getId() == id) {
            return custom;
        }
    }
    return null;
}