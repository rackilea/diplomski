public Page<BankTransactions> get(
  @QuerydslPredicate(root = BankTransactions.class) Predicate predicate,    
      Pageable pageable, @RequestParam MultiValueMap<String, String> parameters) {
    Page<BankTransactions> response = repository.findAll(predicate, pageable);
    return response;

}