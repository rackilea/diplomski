@GetMapping("/list")
public List<MerchantDTO> getMerchantsList() {
    return StreamSupport.stream(merchantRepository.findAll().spliterator(), false)
            .map(mapper::toDTO)
            .collect(Collectors.toList());
}