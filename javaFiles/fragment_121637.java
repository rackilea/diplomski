// Create a new file and give it some content
IFileItem file = (IFileItem) IFileItem.ITEM_TYPE.createItem();
file.setName("file.txt");
file.setParent(projectFolder);

// Create file content.
IFileContentManager contentManager = FileSystemCore.getContentManager(repository);
IFileContent fileContent = contentManager.storeContent(
              "UTF-8",
              FileLineDelimiter.LINE_DELIMITER_LF,
              new VersionedContentManagerByteArrayInputStreamPovider(BYTE_ARRAY),
              null,
              null);

file.setContent(fileContent);
file.setContentType(IFileItem.CONTENT_TYPE_TEXT);
file.setFileTimestamp(new Date());

workspaceConnection.configurationOpFactory().save(file);