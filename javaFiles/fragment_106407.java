public static void createNewFolderIn(String serverUrl, String username, String password, String path, String folderName) {
    Folder root = getFolderByPath(serverUrl, username, password, path);
    Map<String, Object> properties = new HashMap<>();
    properties.put(PropertyIds.OBJECT_TYPE_ID, BaseTypeId.CMIS_FOLDER.value());

    properties.put(PropertyIds.NAME, folderName);
    List<Ace> addAces = new LinkedList<>();
    List<Ace> removeAces = new LinkedList<>();
    List<Policy> policies = new LinkedList<>();
    Folder newFolder = root.createFolder(properties, policies, addAces, removeAces, getSession(serverUrl, username, password).getDefaultContext());

  }