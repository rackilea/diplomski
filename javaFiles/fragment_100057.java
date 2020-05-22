private void addGroupsForSubBusiness(SubBusiness sub, DBObject dbObj){
        BasicDBList groups = new BasicDBList();

        for (Group group: sub.getGroups()) {
            DBObject dbGroupObj = new BasicDBObject();
            dbGroupObj.put("group", group.getName());
            groups.add(dbGroupObj);
        }

        dbObj.put("groups", groups);
  }

}