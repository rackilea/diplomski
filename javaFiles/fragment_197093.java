public void fillTree() throws SystemException, PortalException {

    TreeNode nodeParent;
    TreeNode nodeFils;
    Set<Long> managersId = new HashSet<Long>();
    UserVO user = new UserVO();
    collabs = CollabLocalServiceUtil.getCollabs(-1, -1);        
    long id;
    for (int i = 0; i < collabs.size(); i++) {
        id = collabs.get(i).getManagerId();
        synchronized (managersId) {
        managersId.add((Long) id);
        System.out.println(id);

        }

    }

    Iterator<Long> iter = managersId.iterator(); // Getting the new iterator with latest value.
    while (iter.hasNext()) {
        id = iter.next();//Now this wont throw exeption
        user = getUserById(id);
        nodeParent = new DefaultTreeNode(user.getFullName(), root);
        for (int j = 0; j < collabs.size(); j++) {
        if (collabs.get(j).getManagerId() == user.getUserId()) {

            nodeFils = new DefaultTreeNode(getUserById(
                collabs.get(j).getUserId()).getFullName(),
                nodeParent);
        }
        }
    }
}