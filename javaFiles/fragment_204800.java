for(Object pojo: pojoObjects) {
    int parentId = pojo.parent_id;
    ArrayList<Pojo> atThisIndex = finalTree[parentId];
    atThisIndex.add(pojo);
    finalTree[parentId] = atThisIndex;
}