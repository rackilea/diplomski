@PostMapping(path="/kind/add")
public Kind addNewKind(@RequestBody Kind kind) throws Exception {
    if (kind.getName() == null) {
        throw new Exception("Name not found.");
    }
    return kindRepository.save(kind);
}