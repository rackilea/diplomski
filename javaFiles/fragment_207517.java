Product findOneById(Long id, boolean withTags){
  if(withTags){
    return productRepository.findOneByIdWithEntityGraphTags(id);
  } else {
    return productRepository.findOne(id);
  }
}