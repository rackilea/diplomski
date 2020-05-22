public Folder findById(Long id) {

    Optional<Folder> folder = folderRepository.findById(id);

    if (!folder.isPresent())
        return null;

    return folder.get();
}