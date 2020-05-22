Long id = ...
if (repository.exists(id)) {
    Organization organization = repository.getOne(id);

    // ...
    // Update objects field e.g. organization.setName("New Name");
    // ...

    repository.save(organisation);
}