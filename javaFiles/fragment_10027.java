UserGroup service = new UserGroup();
UserGroupSoap port = service.getUserGroupSoap();

GetUserCollectionFromGroupResult usersCollection = port.getUserCollectionFromGroup(Settings.usersGroup);
List<Object> content = usersCollection.getContent();
org.w3c.dom.Element usersElement = (org.w3c.dom.Element) content.get(0);