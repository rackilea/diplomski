@PostMapping(path="/kind/add")
public String addNewKind(@RequestBody Kind kind) throws Exception {
    if (kind.getName() == null) {
        throw new Exception("Name not found.");
    }
    kindRepository.save(kind);
    return "Saved";
}