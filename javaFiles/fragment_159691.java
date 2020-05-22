Group group = mgr.getObjectById(Group.class, id);
group.getIouList()

for(IOU objIOU : group.getIouList()){
    objIOU.getFromUserId();
}