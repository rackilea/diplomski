@GetMapping("/reference_transaction_id/{id}")
@ResponseBody
public ResponseEntity<List<PaymentTransactionsDTO>> getByListReference_transaction_id(@PathVariable Integer id) {
    try(var stream = transactionService
            .findListByReference_transaction_id(id)){
      var list = stream.map(mapper::toDTO).collect(Collectors.toList());
      return list.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(list) 
    }
}