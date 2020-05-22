Client client;
try {
    client = clientService.getOrCreate(name);
}
catch (ConstraintViolationException e) {
    client = clientService.getOrCreate(name);
}