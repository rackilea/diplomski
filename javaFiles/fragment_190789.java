Folder folder = jdbcTemplate.query( query, (ResultSetExtractor<Folder>) r -> {
    Folder folder = new Folder();
    folder.setId(r.getLong("id"));
    folder.setFolderName(r.getString("folder_name"));
    folder.setFullPath(r.getString("full_path"));
    return folder;
}, folderId);

folders.add(folder);

return folders;