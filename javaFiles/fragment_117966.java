@GetMapping("/list")
public ResponseEntity<List<MerchantDTO>> getMerchantsList() {
    List<MerchantDTO> list = StreamSupport.stream(merchantRepository.findAll().spliterator(), false)
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    return ResponseEntity.ok(list);
}