private void <T extends MetadataObject>importMetadata(CrudRepository<T, String> mRepository) {
   Optional<T> currentOptional = mRepository.findById(1);

   if (currentOptional.isPresent()) {
       T current = currentOptional.get();
       current.setName("a1");
       mRepository.save(current);
   }
}