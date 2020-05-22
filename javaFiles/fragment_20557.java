Criteria criteria = session.createCriteria(Document.class, "document");
criteria.add(Restrictions.eq("document.nice", true));
criteria.createAlias("document.folder", "folder");
criteria.add(Restrictions.eq("folder.yellow", true));
criteria.add(Subqueries.exists(clipOwnerWithNameInFolder(name, "folder"));

private DetachedCriteria clipOwnerWithName(String searchedName, String aliasOfFolder) {
    DetachedCriteria c = DetachedCriteria.forClass(Clip.class, "clip");
    c.createAlias("clip.owner", "owner");
    c.createAlias("clip.folder", "clipFolder");
    c.add(Restrictions.propertyEq("clipFolder.id", aliasOfFolder + ".id");
    c.add(Restrictions.like("owner.name", searchedName);
    c.setProjection(Projections.id());
}