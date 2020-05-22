for(GroupAccount groupAccount : groupMembers.getGroupAccounts()) {
    groupAccount.getGroupMembersSet().remove(this);
}
groupMembers.getGroupAccounts().clear();
session.flush();
session.delete(groupMembers);